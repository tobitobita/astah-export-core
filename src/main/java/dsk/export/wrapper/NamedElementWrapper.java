package dsk.export.wrapper;

import com.change_vision.jude.api.inf.model.INamedElement;
import dsk.common.exception.DskRuntimeException;

public class NamedElementWrapper {

    private final INamedElement namedElement;

    public NamedElementWrapper(INamedElement namedElement) {
        super();
        this.namedElement = namedElement;
    }

    public String getName() {
        return this.namedElement.getName();
    }

    public VisibilityKind getVisibility() {
        if (this.namedElement.isPublicVisibility()) {
            return VisibilityKind.PUBLIC;
        } else if (this.namedElement.isProtectedVisibility()) {
            return VisibilityKind.PROTECTED;
        } else if (this.namedElement.isPackageVisibility()) {
            return VisibilityKind.PACKAGE;
        } else if (this.namedElement.isPrivateVisibility()) {
            return VisibilityKind.PRIVATE;
        }
        throw new DskRuntimeException("可視性が不正です。astahのバグです。");
    }

}
