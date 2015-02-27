package dsk.export.wrapper;

import com.change_vision.jude.api.inf.model.IOperation;
import java.util.List;

public class OperationWrapper extends NamedElementWrapper{

    private final IOperation operation;

    public OperationWrapper(IOperation operation) {
        super(operation);
        this.operation = operation;
    }

    public String getReturnTypeExpression() {
        return operation.getReturnTypeExpression();
    }

    public boolean isLeaf() {
        return operation.isLeaf();
    }

    public boolean isAbstract() {
        return operation.isAbstract();
    }

    public boolean isStatic() {
        return operation.isStatic();
    }
    
    List<ParameterWrapper> getParameters() {
        return null;
    }
}
