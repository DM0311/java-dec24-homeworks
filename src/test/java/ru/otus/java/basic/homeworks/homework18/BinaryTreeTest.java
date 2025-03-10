package ru.otus.java.basic.homeworks.homework18;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.otus.java.basic.homeworks.homework18.advanced.BinaryTree;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BinaryTreeTest {
    @Test
    public void buildTreeTest(){
        var sortedList = List.of(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        var tree = new BinaryTree<>(sortedList);
        Assertions.assertEquals(sortedList, tree.getSortedList());
    }

    @Test
    public void searchingRightTest(){
        var sortedList = List.of(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        var tree = new BinaryTree<>(sortedList);
        Assertions.assertEquals(1, tree.find(1));
        Assertions.assertEquals(10, tree.find(10));
    }

    @Test
    public void searchingEmptyTreeTest(){
        var sortedList = List.of(new Integer[]{});
        var tree = new BinaryTree<>(sortedList);
        Assertions.assertThrows(RuntimeException.class, () -> tree.find(1));
    }

    @Test
    public void balancedTreeTest(){
        var sortedList = IntStream.iterate(0, i -> i + 1).limit(10_000).boxed().collect(Collectors.toList());
        var tree = new BinaryTree<>(sortedList,true);
        Assertions.assertEquals(2, tree.find(2));
    }
}
