package okhttp3.body;

import java.io.IOException;
import okio.BufferedSink;
import okio.BufferedSource;

public abstract class ReceivableBody extends Body {
  @Override public abstract BufferedSource source();

  @Override public final void writeTo(BufferedSink sink) throws IOException {
    throw new UnsupportedOperationException();
  }
}
