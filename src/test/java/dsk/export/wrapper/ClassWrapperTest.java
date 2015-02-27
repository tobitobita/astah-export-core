package dsk.export.wrapper;

import com.change_vision.jude.api.inf.AstahAPI;
import com.change_vision.jude.api.inf.exception.LicenseNotFoundException;
import com.change_vision.jude.api.inf.exception.NonCompatibleException;
import com.change_vision.jude.api.inf.exception.ProjectLockedException;
import com.change_vision.jude.api.inf.exception.ProjectNotFoundException;
import com.change_vision.jude.api.inf.model.IClass;
import com.change_vision.jude.api.inf.model.INamedElement;
import com.change_vision.jude.api.inf.project.ProjectAccessor;
import java.io.IOException;
import java.util.List;
import org.junit.*;
import org.junit.Test;

public class ClassWrapperTest {

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
        Assert.assertEquals("", model.getTypeModifier());
        Assert.assertEquals(false, model.isAbstract());
        Assert.assertEquals(false, model.isActive());
        Assert.assertEquals(false, model.isLeaf());
        Assert.assertEquals(false, model.isReadOnly());
        // 属性がらみ
        List<AttributeWrapper> attributes = model.getAttributes();
        Assert.assertEquals(10, attributes.size());
        Assert.assertEquals("属性0", attributes.get(0).getName());
        Assert.assertEquals("", attributes.get(0).getInitialValue());
        Assert.assertEquals("int", attributes.get(0).getTypeExpression());
        Assert.assertSame(VisibilityKind.PRIVATE, attributes.get(0).getVisibility());
        Assert.assertTrue(attributes.get(0).isChangeable());
        Assert.assertFalse(attributes.get(0).isStatic());
        Assert.assertEquals("属性1", attributes.get(1).getName());
        Assert.assertEquals("", attributes.get(1).getInitialValue());
        Assert.assertEquals("byte", attributes.get(1).getTypeExpression());
        Assert.assertSame(VisibilityKind.PACKAGE, attributes.get(1).getVisibility());
        Assert.assertTrue(attributes.get(1).isChangeable());
        Assert.assertFalse(attributes.get(1).isStatic());
        Assert.assertEquals("属性2", attributes.get(2).getName());
        Assert.assertEquals("", attributes.get(2).getInitialValue());
        Assert.assertEquals("long", attributes.get(2).getTypeExpression());
        Assert.assertSame(VisibilityKind.PROTECTED, attributes.get(2).getVisibility());
        Assert.assertTrue(attributes.get(2).isChangeable());
        Assert.assertFalse(attributes.get(2).isStatic());
        Assert.assertEquals("属性3", attributes.get(3).getName());
        Assert.assertEquals("", attributes.get(3).getInitialValue());
        Assert.assertEquals("クラス1", attributes.get(3).getTypeExpression());
        Assert.assertSame(VisibilityKind.PUBLIC, attributes.get(3).getVisibility());
        Assert.assertTrue(attributes.get(3).isChangeable());
        Assert.assertFalse(attributes.get(3).isStatic());
        Assert.assertEquals("属性4", attributes.get(4).getName());
        Assert.assertEquals("", attributes.get(4).getInitialValue());
        Assert.assertEquals("int", attributes.get(4).getTypeExpression());
        Assert.assertSame(VisibilityKind.PRIVATE, attributes.get(4).getVisibility());
        Assert.assertTrue(attributes.get(4).isChangeable());
        Assert.assertTrue(attributes.get(4).isStatic());
        Assert.assertEquals("属性5", attributes.get(5).getName());
        Assert.assertEquals("", attributes.get(5).getInitialValue());
        Assert.assertEquals("int", attributes.get(5).getTypeExpression());
        Assert.assertSame(VisibilityKind.PRIVATE, attributes.get(5).getVisibility());
        Assert.assertFalse(attributes.get(5).isChangeable());
        Assert.assertFalse(attributes.get(5).isStatic());
        Assert.assertEquals("属性6", attributes.get(6).getName());
        Assert.assertEquals("", attributes.get(6).getInitialValue());
        Assert.assertEquals("int", attributes.get(6).getTypeExpression());
        Assert.assertSame(VisibilityKind.PRIVATE, attributes.get(6).getVisibility());
        Assert.assertFalse(attributes.get(6).isChangeable());
        Assert.assertTrue(attributes.get(6).isStatic());
        Assert.assertEquals("target2", attributes.get(7).getName());
        Assert.assertEquals("", attributes.get(7).getInitialValue());
        Assert.assertEquals("クラス2", attributes.get(7).getTypeExpression());
        Assert.assertSame(VisibilityKind.PRIVATE, attributes.get(7).getVisibility());
        Assert.assertTrue(attributes.get(7).isChangeable());
        Assert.assertFalse(attributes.get(7).isStatic());
        Assert.assertEquals("target3", attributes.get(8).getName());
        Assert.assertEquals("", attributes.get(8).getInitialValue());
        Assert.assertEquals("クラス3", attributes.get(8).getTypeExpression());
        Assert.assertSame(VisibilityKind.PRIVATE, attributes.get(8).getVisibility());
        Assert.assertTrue(attributes.get(8).isChangeable());
        Assert.assertFalse(attributes.get(8).isStatic());
        Assert.assertEquals("sampleList", attributes.get(9).getName());
        Assert.assertEquals("", attributes.get(9).getInitialValue());
        Assert.assertEquals("List<T>", attributes.get(9).getTypeExpression());
        Assert.assertSame(VisibilityKind.PRIVATE, attributes.get(9).getVisibility());
        Assert.assertTrue(attributes.get(9).isChangeable());
        Assert.assertFalse(attributes.get(9).isStatic());
        // 操作がらみ
        List<OperationWrapper> operations = model.getOperations();
        Assert.assertEquals(7, operations.size());
        Assert.assertEquals("操作0", operations.get(0).getName());
        Assert.assertEquals("操作1", operations.get(1).getName());
        Assert.assertEquals("操作2", operations.get(2).getName());
        Assert.assertEquals("操作3", operations.get(3).getName());
        Assert.assertEquals("クラス0", operations.get(4).getName());
        Assert.assertEquals("操作5", operations.get(5).getName());
        Assert.assertEquals("操作6", operations.get(6).getName());
    }
}
