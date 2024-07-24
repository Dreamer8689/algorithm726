package com.dreamer.algorithm.day200;


import java.util.HashMap;
import java.util.Map;

//
// 设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存被填满时，它应该删除最近最少使用的项目。
//
//它应该支持以下操作： 获取数据 get 和 写入数据 put 。
//
//获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
public class LRUCache1 {
    class DlNode {
        int key;
        int value;
        DlNode prev;
        DlNode next;
        public DlNode() {}
        public DlNode(int key, int value) {key = key; value = value;}
    }

    private Map<Integer, DlNode> cache = new HashMap<Integer, DlNode>();
    private int size;
    private int capacity;
    private DlNode head, tail;


    public LRUCache1(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DlNode();
        tail = new DlNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DlNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DlNode node = cache.get(key);
        if (node == null) {
            DlNode newNode = new DlNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                DlNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DlNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DlNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DlNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DlNode removeTail() {
        DlNode res = tail.prev;
        removeNode(res);
        return res;
    }
}

