package dsk.export.wrapper;

import com.change_vision.jude.api.inf.model.IAttribute;

public class AttributeWrapper extends NamedElementWrapper {

    private final IAttribute attribute;

    public AttributeWrapper(IAttribute attribute) {
        super(attribute);
        this.attribute = attribute;
    }

    public String getTypeExpression() {
        return attribute.getTypeExpression();
    }

    public String getInitialValue() {
        return attribute.getInitialValue();
    }

    public boolean isChangeable() {
        return attribute.isChangeable();
    }

    public boolean isStatic() {
        return attribute.isStatic();
    }
}
