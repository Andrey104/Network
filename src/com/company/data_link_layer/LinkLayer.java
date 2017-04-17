package com.company.data_link_layer;


import com.company.physical_layer.PhysicalLayer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class LinkLayer implements Runnable {
    private static AtomicInteger inc = new AtomicInteger();
    private PhysicalLayer layer;
    private InputStream is;
    private OutputStream os;
    private boolean connected = false;
    ExecutorService ex = Executors.newSingleThreadExecutor();

    public LinkLayer(String port) {
        layer = PhysicalLayer.open(port);
        if (layer == null) return;
        is = layer.getInputStream();
        os = layer.getOutputStream();
        connected = true;
        ex.execute(this);
    }

    public void send(byte[] message) {
        Frame frame = new Frame(inc.getAndIncrement(), message);
        try {
            os.write(frame.toByte());
        } catch (IOException e) {
            connected = false;
        }
    }

    public void run() {
        Frame frame = Frame.read(is);
        if (frame == null) {
            connected = false;
            ex.shutdown();
            return;
        }
        System.out.println(frame.id);
        System.out.println(new String(frame.message));
    }


}
