package dsk.export.wrapper;

import com.change_vision.jude.api.inf.model.IOperation;
import java.util.List;

public class OperationWrapper {

    private final IOperation operation;

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
