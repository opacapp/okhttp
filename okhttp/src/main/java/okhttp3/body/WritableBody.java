package okhttp3.body;

import java.io.IOException;
import okio.BufferedSink;
import okio.BufferedSource;

public abstract class WritableBody extends Body {
  @Override public final BufferedSource source() {
    throw new UnsupportedOperationException();
  }

  @Override
  public abstract void writeTo(BufferedSink sink) throws IOException;
}
