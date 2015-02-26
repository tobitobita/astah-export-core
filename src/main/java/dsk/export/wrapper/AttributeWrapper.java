package dsk.export.wrapper;

import com.change_vision.jude.api.inf.model.IAttribute;

public class AttributeWrapper {

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
