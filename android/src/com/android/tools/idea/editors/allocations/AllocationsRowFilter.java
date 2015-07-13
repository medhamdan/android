/*
 * Copyright (C) 2014 The Android Open Source Project
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
package com.android.tools.idea.editors.allocations;

import com.intellij.ui.components.JBCheckBox;
import com.intellij.ui.components.JBTextField;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.TableModel;

public class AllocationsRowFilter extends RowFilter<TableModel,Integer> {
  private final AllocationsTableModel myModel;
  private final JBTextField myFilterField;
  private final JBCheckBox myIncludeTraceCheckBox;

  public AllocationsRowFilter(
    @NotNull AllocationsTableModel model, @NotNull JBTextField filterField, @NotNull JBCheckBox includeTraceCheckBox) {
    myModel = model;
    myFilterField = filterField;
    myIncludeTraceCheckBox = includeTraceCheckBox;
  }

  @Override
  public boolean include(Entry<? extends TableModel, ? extends Integer> entry) {
    return myModel.getAllocation(entry.getIdentifier()).filter(myFilterField.getText(), myIncludeTraceCheckBox.isSelected(),
                                                               myFilterField.getLocale());
  }
}