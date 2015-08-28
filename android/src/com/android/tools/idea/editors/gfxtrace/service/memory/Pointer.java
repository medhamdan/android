/*
 * Copyright (C) 2015 The Android Open Source Project
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
 *
 * THIS FILE WAS GENERATED BY codergen. EDIT WITH CARE.
 */
package com.android.tools.idea.editors.gfxtrace.service.memory;

import com.android.tools.rpclib.binary.*;
import com.android.tools.rpclib.schema.Render;
import com.intellij.ui.SimpleColoredComponent;
import com.intellij.ui.SimpleTextAttributes;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public final class Pointer implements BinaryObject, Render.ToComponent {
  @Override
  public void render(@NotNull SimpleColoredComponent component, SimpleTextAttributes defaultAttributes) {
    component.append("0x" + Long.toHexString((Long)myAddress), defaultAttributes);
    component.append("0x" + Long.toHexString((Long)myAddress), defaultAttributes);
    if (myPool.value != PoolID.ApplicationPool) {
      component.append("@", SimpleTextAttributes.GRAY_ATTRIBUTES);
      component.append(myPool.toString(), defaultAttributes);
    }
  }

  //<<<Start:Java.ClassBody:1>>>
  private long myAddress;
  private PoolID myPool;

  // Constructs a default-initialized {@link Pointer}.
  public Pointer() {}


  public long getAddress() {
    return myAddress;
  }

  public Pointer setAddress(long v) {
    myAddress = v;
    return this;
  }

  public PoolID getPool() {
    return myPool;
  }

  public Pointer setPool(PoolID v) {
    myPool = v;
    return this;
  }

  @Override @NotNull
  public BinaryClass klass() { return Klass.INSTANCE; }

  private static final byte[] IDBytes = {50, -111, 32, 44, 113, 28, -103, -45, -34, -83, -42, -85, -84, 103, 120, -83, -3, -75, 5, -7, };
  public static final BinaryID ID = new BinaryID(IDBytes);

  static {
    Namespace.register(ID, Klass.INSTANCE);
  }
  public static void register() {}
  //<<<End:Java.ClassBody:1>>>
  public enum Klass implements BinaryClass {
    //<<<Start:Java.KlassBody:2>>>
    INSTANCE;

    @Override @NotNull
    public BinaryID id() { return ID; }

    @Override @NotNull
    public BinaryObject create() { return new Pointer(); }

    @Override
    public void encode(@NotNull Encoder e, BinaryObject obj) throws IOException {
      Pointer o = (Pointer)obj;
      e.uint64(o.myAddress);
      o.myPool.encode(e);
    }

    @Override
    public void decode(@NotNull Decoder d, BinaryObject obj) throws IOException {
      Pointer o = (Pointer)obj;
      o.myAddress = d.uint64();
      o.myPool = PoolID.decode(d);
    }
    //<<<End:Java.KlassBody:2>>>
  }
}