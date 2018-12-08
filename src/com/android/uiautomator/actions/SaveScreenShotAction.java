/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.uiautomator.actions;

import com.android.uiautomator.UiAutomatorViewer;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.ImageTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;

import java.io.File;

public class SaveScreenShotAction extends Action {
    private static final String PNG_TYPE = ".png";
    private static final String UIX_TYPE = ".uix";
    private UiAutomatorViewer mViewer;

    public SaveScreenShotAction(UiAutomatorViewer viewer) {
        super("&Save");
        mViewer = viewer;
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return ImageHelper.loadImageDescriptorFromResource("images/copy.png");
    }

    @Override
    public void run() {
        final Image screenshot = mViewer.getScreenShot();
        final File model = mViewer.getModelFile();
        if (model == null || screenshot == null) {
            return;
        }

        setClipboardImage(screenshot.getImageData());
        //MessageDialog.openInformation(Display.getDefault().getActiveShell(), "提示", "已复制到粘贴板");
    }

    /***
     * 复制图片到剪切板
     */
    public void setClipboardImage(ImageData data) {
        ImageTransfer imageTransfer = ImageTransfer.getInstance();
        Clipboard clipboard = new Clipboard(Display.getDefault());
        clipboard.setContents(new Object[]{data}, new Transfer[]{imageTransfer});
    }
}
