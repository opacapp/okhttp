package okhttp3.body;

import okhttp3.MediaType;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.BufferedSource;

import java.io.IOException;

public abstract class Body {
  /**
   * Returns the {@link MediaType} for this body.
   */
  public MediaType contentType() {
    return null;
  }

  /**
   * Returns the content length or -1 when the content length is unknown.
   */
  public long contentLength() {
    return -1L;
  }

  /**
   * Returns a {@link BufferedSource} to read the contents of this {@link Body}.
   * throws {link {@link UnsupportedOperationException}} if this body is not readable.
   */
  public BufferedSource source() {
    throw new UnsupportedOperationException();
  }

  /**
   * Implementations of this method should write the contents of this body to the
   * given {@link BufferedSink}.
   * throws {link {@link UnsupportedOperationException}} if this body is not writable.
   */
  public void writeTo(BufferedSink sink) throws IOException {
    throw new UnsupportedOperationException();
  }

  /**
   * Creates an immutable body that can be used to write or read data.
   */
  public static Body create(MediaType contentType, byte[] content) {
    return new ImmutableBody(contentType, content.length, content);
  }

  /**
   * Creates a writable body to stream data out.
   */
  public static Body create(MediaType contentType, String s) {
    byte[] bytes = s.getBytes(contentType.charset(Util.UTF_8));
    return create(contentType, bytes);
  }

  public static void main(String[] args) {
    byte[] bytes = { 65, 66 };
    Body body = Body.create(null, bytes);
    System.out.println(body.source().readByte());
    System.out.println(body.source().readByte());
  }
}
