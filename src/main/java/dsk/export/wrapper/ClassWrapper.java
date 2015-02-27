package dsk.export.wrapper;

import com.change_vision.jude.api.inf.model.IAttribute;
import com.change_vision.jude.api.inf.model.IClass;
import com.change_vision.jude.api.inf.model.IOperation;
import java.util.LinkedList;
import java.util.List;

public class ClassWrapper extends NamedElementWrapper{

    private final IClass clazz;
    private List<AttributeWrapper> attributes;
    private List<OperationWrapper> operations;

    public ClassWrapper(IClass clazz) {
        super(clazz);
        this.clazz = clazz;
    }

    public String getKind() {
        return this.clazz.hasStereotype("interface") ? "interface" : "class";
    }

    public boolean isAbstract() {
        return this.clazz.isAbstract();
    }

    public boolean isLeaf() {
        return clazz.isLeaf();
    }

    public boolean isActive() {
        return clazz.isActive();
    }

    public boolean isReadOnly() {
        return clazz.isReadOnly();
    }

    public String getTypeModifier() {
        return clazz.getTypeModifier();
    }

    List<AttributeWrapper> getAttributes() {
        if (this.attributes == null) {
            attributes = new LinkedList<>();
            for (IAttribute attribute : this.clazz.getAttributes()) {
                attributes.add(new AttributeWrapper(attribute));
            }
        }
        return attributes;
    }

    List<OperationWrapper> getOperations() {
        if (this.operations == null) {
            operations = new LinkedList<>();
            for (IOperation operation : this.clazz.getOperations()) {
                operations.add(new OperationWrapper(operation));
            }
        }
        return operations;
    }

//    public IClass[] getNestedClasses() {
//        return clazz.getNestedClasses();
//    }
//
//    public IGeneralization[] getGeneralizations() {
//        return clazz.getGeneralizations();
//    }
//
//    public IGeneralization[] getSpecializations() {
//        return clazz.getSpecializations();
//    }
//
//    public IClassifierTemplateParameter[] getTemplateParameters() {
//        return clazz.getTemplateParameters();
//    }
//
//    public ITemplateBinding[] getTemplateBindings() {
//        return clazz.getTemplateBindings();
//    }
}
