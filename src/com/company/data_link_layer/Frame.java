package com.company.data_link_layer;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class Frame {

    public final int id;
    public final FrameType type;
    public final int length;
    public final byte[] message;

    private Frame(int id, FrameType type, byte[] message) {
        this.id = id;
        this.type = type;
        this.length = message == null ? 0 : message.length;
        this.message = message;
    }

    public Frame(int id, byte[] message) {
        this(id, FrameType.DATA, message);
    }

    public Frame(int id, FrameType type) {
        this(id, type, null);
    }

    public static Frame read(InputStream is) {
        DataInputStream dis = new DataInputStream(is);
        try {
            int id = dis.readInt();
            int type = dis.readByte();
            int length = dis.readInt();
            byte[] message = new byte[length];
            dis.readFully(message);
            return new Frame(id, FrameType.values()[type], message);
        } catch (IOException e) {
            return null;
        }
    }

    public byte[] toByte() {
        ByteBuffer bb = ByteBuffer.allocate(Integer.BYTES + Byte.BYTES + Integer.BYTES + length);
        bb.putInt(id).put((byte) type.ordinal()).putInt(length).put(message);
        return bb.array();
    }

    public enum FrameType {
        CONNECT, DATA, ACK, NCK
    }
}
