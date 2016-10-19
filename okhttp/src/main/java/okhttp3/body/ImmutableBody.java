package okhttp3.body;

import okhttp3.MediaType;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;

import java.io.IOException;

final class ImmutableBody extends Body {
  private final MediaType contentType;
  private final long contentLength;
  private final byte[] content;
  private Buffer source;

  ImmutableBody(MediaType contentType, long contentLength, byte[] content) {
    this.contentType = contentType;
    this.contentLength = contentLength;
    this.content = content;
  }

  @Override
  public MediaType contentType() {
    return contentType;
  }

  @Override
  public long contentLength() {
    return contentLength;
  }

  @Override
  public BufferedSource source() {
    if (source == null) source = new Buffer().write(content);
    return source;
  }

  @Override
  public void writeTo(BufferedSink sink) throws IOException {
    sink.write(content);
  }
}
