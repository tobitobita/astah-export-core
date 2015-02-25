package dsk.export;

import com.change_vision.jude.api.inf.model.IAttribute;
import com.change_vision.jude.api.inf.model.IClass;
import com.change_vision.jude.api.inf.model.IOperation;
import com.change_vision.jude.api.inf.model.IParameter;
import java.util.List;

public class ModelWrapper {

    private IClass clazz;

    public ModelWrapper(IClass clazz) {
        this.clazz = clazz;
    }

    public String getClassName() {
        return null;
    }

    List<AttributeWrapper> getAttributes() {
        return null;
    }

    List<OperationWrapper> getOperations() {
        return null;
    }

    private static class AttributeWrapper {

        private IAttribute attribute;

        public AttributeWrapper(IAttribute attribute) {
            this.attribute = attribute;
        }

        public String getVisibility() {
            return null;
        }

        public String getAttributeName() {
            return null;
        }

        public String getTypeName() {
            return null;
        }
    }

    private static class OperationWrapper {

        private IOperation operation;

        public OperationWrapper(IOperation operation) {
            this.operation = operation;
        }

        public String getVisibility() {
            return null;
        }

        public String getOperationName() {
            return null;
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

    private static class ParameterWrapper {

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
