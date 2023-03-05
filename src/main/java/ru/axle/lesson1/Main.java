package ru.axle.lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            strings.add(String.valueOf(i));
        }
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }
        System.out.println("string linear search test: " + linearIndexSearch(strings, "5"));
        System.out.println("integer linear search test: " + linearIndexSearch(integers, 7));
        System.out.println("====================");
        System.out.println("binary search test 1: " + binarySearch(integers, 7));
        System.out.println("binary search test 2: " + binarySearch(integers, 2));
        System.out.println("====================");
        List<Integer> list1 = Arrays.asList(11, 32, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(2, 3, 11, 5);
        System.out.println("searchForOccurrences: " + searchForOccurrences(list1, list2));
        List<Integer> list3 = Arrays.asList(23, 67, 32, 45, 55, 87, 2, 6,90);
        List<Integer> list4 = Arrays.asList(32, 45, 55, 87);
        System.out.println("searchForOccurrences: " + searchForOccurrences(list3, list4));
    }

    //TASK 1
    private static <T> int linearIndexSearch(List<T> list, T elToSearch) {
        int iterationsAmount = 0;
        for (int i = 0; i < list.size(); i++) {
            iterationsAmount++;
            if (list.get(i).equals(elToSearch)) {
                System.out.println("iterationsAmount: " + iterationsAmount);
                return i;
            }
        }
        return -1;
    }

    //TASK 2
    private static int binarySearch(List<Integer> list, Integer item) {
        int low = 0;
        int high = list.size() - 1;
        int iterationsAmount = 0;
        while (low <= high) {
            iterationsAmount++;
            int mid = (low + high) / 2;
            int guess = list.get(mid);
            if (guess == item) {
                System.out.println("iterationsAmount: " + iterationsAmount);
                return list.get(mid);
            }
            if (guess > item) {
                high = mid - 1;
            } else low = mid + 1;
        }
        return -1;
    }

    //TASK 3
    private static List<Integer> searchForOccurrences(List<Integer> list1, List<Integer> list2) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            int tmp = 0;
            for (int j = 0; j < list2.size(); j++) {
                if (!list1.get(i).equals(list2.get(j))) {
                    tmp++;
                }
            }
            if (tmp == list2.size()) {
                res.add(list1.get(i));
            }
        }
        return res;
    }

}
