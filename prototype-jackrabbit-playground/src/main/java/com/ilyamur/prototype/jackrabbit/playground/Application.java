package com.ilyamur.prototype.jackrabbit.playground;

import org.apache.jackrabbit.oak.jcr.Jcr;
import org.apache.jackrabbit.oak.plugins.segment.SegmentNodeStore;
import org.apache.jackrabbit.oak.plugins.segment.file.FileStore;

import javax.jcr.Node;
import javax.jcr.Repository;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;

import java.io.File;

public class Application {

    public static void main(String[] args) throws Exception {

        FileStore fileStore = FileStore.builder(new File("prototype-jackrabbit-playground/repository")).build();
        SegmentNodeStore ns = SegmentNodeStore.builder(fileStore).build();
        Repository repository = new Jcr(ns).createRepository();

        Session session = repository.login(new SimpleCredentials("admin", "admin".toCharArray()));
        Node root = session.getRootNode();
        if (root.hasNode("hello")) {
            Node hello = root.getNode("hello");
            long count = hello.getProperty("count").getLong();
            hello.setProperty("count", count + 1);
            System.out.println("found the hello node, count = " + count);
        } else {
            System.out.println("creating the hello node");
            root.addNode("hello").setProperty("count", 1);
        }
        session.save();

        session.logout();
        fileStore.close();
    }
}
