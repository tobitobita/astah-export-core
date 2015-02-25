package dsk.export;

import com.change_vision.jude.api.inf.model.IAttribute;
import com.change_vision.jude.api.inf.model.IClass;
import com.change_vision.jude.api.inf.model.IOperation;
import com.change_vision.jude.api.inf.model.IParameter;
import java.util.LinkedList;
import java.util.List;

public class ClassWrapper {

    private final IClass clazz;
    private List<AttributeWrapper> attributes;
    private List<OperationWrapper> operations;

    public ClassWrapper(IClass clazz) {
        this.clazz = clazz;
    }

    public String getName() {
        return this.clazz.getName();
    }

    public String getKind() {
        return this.clazz.hasStereotype("interface") ? "interface" : "class";
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

    public static class AttributeWrapper {

        private final IAttribute attribute;

        public AttributeWrapper(IAttribute attribute) {
            this.attribute = attribute;
        }

        public String getVisibility() {
            return null;
        }

        public String getAttributeName() {
            return this.attribute.getName();
        }

        public String getTypeName() {
            return null;
        }
    }

    public static class OperationWrapper {

        private IOperation operation;

        public OperationWrapper(IOperation operation) {
            this.operation = operation;
        }

        public String getVisibility() {
            return null;
        }

        public String getOperationName() {
            return this.operation.getName();
        }

        public String getReturnTypeName() {
            return null;
        }

        public String getDefaultReturnValue() {
            return null;
        }

        List<ParameterWrapper> getParameters() {
            return null;
        }
    }

    public static class ParameterWrapper {

        private IParameter parameter;

        public ParameterWrapper(IParameter parameter) {
            this.parameter = parameter;
        }

        public String getParameterType() {
            return null;
        }

        public String getParameterName() {
            return null;
        }

        public String getTypeName() {
            return null;
        }
    }
}
