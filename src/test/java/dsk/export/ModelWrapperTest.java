package dsk.export;

import com.change_vision.jude.api.inf.AstahAPI;
import com.change_vision.jude.api.inf.exception.LicenseNotFoundException;
import com.change_vision.jude.api.inf.exception.NonCompatibleException;
import com.change_vision.jude.api.inf.exception.ProjectLockedException;
import com.change_vision.jude.api.inf.exception.ProjectNotFoundException;
import com.change_vision.jude.api.inf.model.IClass;
import com.change_vision.jude.api.inf.model.INamedElement;
import com.change_vision.jude.api.inf.project.ProjectAccessor;
import dsk.export.ClassWrapper.AttributeWrapper;
import dsk.export.ClassWrapper.OperationWrapper;
import java.io.IOException;
import java.util.List;
import org.junit.*;
import org.junit.Test;

public class ModelWrapperTest {

    private ProjectAccessor api;

    @Before
    public void setUp() throws LicenseNotFoundException, ProjectNotFoundException, NonCompatibleException, IOException, ClassNotFoundException, ProjectLockedException {
        api = AstahAPI.getAstahAPI().getProjectAccessor();
        api.open("src/test/resources/test.asta");
    }

    private IClass findClassByName(String name) throws ProjectNotFoundException {
        INamedElement[] namedElements = api.findElements(IClass.class);
        for (INamedElement namedElement : namedElements) {
            if (namedElement.getName().equals(name)) {
                return (IClass) namedElement;
            }
        }
        return null;
    }

    @After
    public void tearDown() {
        api.close();
    }

    @Test
    public void loadAndPrintAstah() throws ProjectNotFoundException {
        IClass clazz = this.findClassByName("クラス0");
        Assert.assertNotNull(clazz);
        ClassWrapper model = new ClassWrapper(clazz);
        // クラスがらみ
        Assert.assertEquals("クラス0", model.getName());
        Assert.assertEquals("class", model.getKind());
        // 属性がらみ
        List<AttributeWrapper> attributes = model.getAttributes();
        Assert.assertEquals(10, attributes.size());
        Assert.assertEquals("属性0", attributes.get(0).getAttributeName());
        Assert.assertEquals("属性1", attributes.get(1).getAttributeName());
        Assert.assertEquals("属性2", attributes.get(2).getAttributeName());
        Assert.assertEquals("属性3", attributes.get(3).getAttributeName());
        Assert.assertEquals("属性4", attributes.get(4).getAttributeName());
        Assert.assertEquals("属性5", attributes.get(5).getAttributeName());
        Assert.assertEquals("属性6", attributes.get(6).getAttributeName());
        Assert.assertEquals("target2", attributes.get(7).getAttributeName());
        Assert.assertEquals("target3", attributes.get(8).getAttributeName());
        Assert.assertEquals("sampleList", attributes.get(9).getAttributeName());
        // 操作がらみ
        List<OperationWrapper> operations = model.getOperations();
        Assert.assertEquals(7, operations.size());
        Assert.assertEquals("操作0", operations.get(0).getOperationName());
        Assert.assertEquals("操作1", operations.get(1).getOperationName());
        Assert.assertEquals("操作2", operations.get(2).getOperationName());
        Assert.assertEquals("操作3", operations.get(3).getOperationName());
        Assert.assertEquals("クラス0", operations.get(4).getOperationName());
        Assert.assertEquals("操作5", operations.get(5).getOperationName());
        Assert.assertEquals("操作6", operations.get(6).getOperationName());
    }
}
