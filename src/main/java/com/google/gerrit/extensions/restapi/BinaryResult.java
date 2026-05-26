// Copyright (C) 2012 The Android Open Source Project
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.google.gerrit.extensions.restapi;

import static java.nio.charset.StandardCharsets.UTF_8;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.UnsupportedCharsetException;

/**
 * Wrapper around a non-JSON result from a {@link RestView}.
 *
 * <p>Views may return this type to signal they want the server glue to write raw data to the
 * client, instead of attempting automatic conversion to JSON. The create form is overloaded to
 * handle plain text from a String, or binary data from a {@code byte[]} or {@code InputSteam}.
 */
public abstract class BinaryResult implements Closeable {

    /**
     * Default MIME type for unknown binary data.
     */
    static final String OCTET_STREAM = "application/octet-stream";

    /**
     * Produce a UTF-8 encoded result from a string.
     */
    public static BinaryResult create(String data) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Produce an {@code application/octet-stream} result from a byte array.
     */
    public static BinaryResult create(byte[] data) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Produce an {@code application/octet-stream} of unknown length by copying the InputStream until
     * EOF. The server glue will automatically close this stream when copying is complete.
     */
    public static BinaryResult create(InputStream data) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private String contentType = OCTET_STREAM;

    private Charset characterEncoding;

    private long contentLength = -1;

    private boolean gzip = true;

    private boolean base64;

    private String attachmentName;

    /**
     * @return the MIME type of the result, for HTTP clients.
     */
    public String getContentType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Set the MIME type of the result, and return {@code this}.
     */
    public BinaryResult setContentType(String contentType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get the character encoding; null if not known.
     */
    public Charset getCharacterEncoding() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Set the character set used to encode text data and return {@code this}.
     */
    public BinaryResult setCharacterEncoding(Charset encoding) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get the attachment file name; null if not set.
     */
    public String getAttachmentName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Set the attachment file name and return {@code this}.
     */
    public BinaryResult setAttachmentName(String attachmentName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return length in bytes of the result; -1 if not known.
     */
    public long getContentLength() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Set the content length of the result; -1 if not known.
     */
    public BinaryResult setContentLength(long len) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return true if this result can be gzip compressed to clients.
     */
    public boolean canGzip() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Disable gzip compression for already compressed responses.
     */
    public BinaryResult disableGzip() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return true if the result must be base64 encoded.
     */
    public boolean isBase64() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Wrap the binary data in base64 encoding.
     */
    public BinaryResult base64() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Write or copy the result onto the specified output stream.
     *
     * @param os stream to write result data onto. This stream will be closed by the caller after this
     *     method returns.
     * @throws IOException if the data cannot be produced, or the OutputStream {@code os} throws any
     *     IOException during a write or flush call.
     */
    public abstract void writeTo(OutputStream os) throws IOException;

    /**
     * Return a copy of the result as a String.
     *
     * <p>The default version of this method copies the result into a temporary byte array and then
     * tries to decode it using the configured encoding.
     *
     * @return string version of the result.
     * @throws IOException if the data cannot be produced or could not be decoded to a String.
     */
    public String asString() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Close the result and release any resources it holds.
     */
    @Override
    public void close() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static String decode(byte[] data, Charset enc) {
        try {
            Charset cs = enc != null ? enc : UTF_8;
            return cs.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(data)).toString();
        } catch (UnsupportedCharsetException | CharacterCodingException e) {
            // Fallback to ISO-8850-1 style encoding.
            StringBuilder r = new StringBuilder(data.length);
            for (byte b : data) {
                r.append((char) (b & 0xff));
            }
            return r.toString();
        }
    }

    private static class Array extends BinaryResult {

        private final byte[] data;

        Array(byte[] data) {
            this.data = data;
            setContentLength(data.length);
        }

        @Override
        public void writeTo(OutputStream os) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String asString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class StringResult extends Array {

        private final String str;

        StringResult(String str) {
            super(str.getBytes(UTF_8));
            setContentType("text/plain");
            setCharacterEncoding(UTF_8);
            this.str = str;
        }

        @Override
        public String asString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class Stream extends BinaryResult {

        private final InputStream src;

        Stream(InputStream src) {
            this.src = src;
        }

        @Override
        public void writeTo(OutputStream dst) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void close() throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
