package com.android.uiautomator.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.RGB;

public class NullAction extends Action {
    @Override
    public ImageDescriptor getImageDescriptor() {
        ImageData data = new ImageData(30, 30, 1, new PaletteData(new RGB[]{new RGB(250, 250, 250)}));
        return ImageDescriptor.createFromImageData(data);
        //return ImageHelper.loadImageDescriptorFromResource("images/copy.png");
    }

    @Override
    public String getText() {
        return "空";
    }
}
