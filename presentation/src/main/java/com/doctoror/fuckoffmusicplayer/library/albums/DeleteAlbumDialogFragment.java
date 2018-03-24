/*
 * Copyright (C) 2017 Yaroslav Mytkalyk
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
package com.doctoror.fuckoffmusicplayer.library.albums;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.doctoror.fuckoffmusicplayer.library.DeleteItemDialogFragment;
import com.doctoror.fuckoffmusicplayer.media.MediaManagerService;

public final class DeleteAlbumDialogFragment extends DeleteItemDialogFragment {

    private static final String TAG = "DeleteAlbumDialogFragment";

    public static void show(
            @NonNull final Context context,
            @NonNull final FragmentManager fragmentManager,
            final long albumId,
            @Nullable final String albumName) {
        DeleteItemDialogFragment.show(context,
                DeleteAlbumDialogFragment.class,
                fragmentManager,
                TAG,
                albumId,
                albumName);
    }

    @Override
    protected void performDelete() {
        final Activity activity = getActivity();
        if (activity != null) {
            MediaManagerService.deleteAlbum(activity, getTargetId());
        }
    }
}