package com.company;

import com.company.data_link_layer.LinkLayer;

public class Main {

    public static void main(String[] args) {
        LinkLayer ll1 = new LinkLayer("COM6");
        LinkLayer ll2 = new LinkLayer("COM7");

        ll1.send("arsgasrgar".getBytes());
    }
}
