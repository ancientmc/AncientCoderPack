/**
 * This class ensures that .mus audio files (used by the music discs) work correctly.
 */

package rcp.client;

import net.minecraft.src.CodecMus;

import java.io.InputStream;

public class CodecMusPatch extends CodecMus {
    @Override
    protected InputStream openInputStream() {
        super.initialize(this.url);
        return super.openInputStream();
    }
}
