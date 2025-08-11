package com.bank.authorization.config;

import lombok.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        int[] test = {1, 1, 1, 1, 2, 2, 5, 5, 5};
        int target = 0;
        for (int num : test) {
            target ^= num;
        }
        System.out.println(target);
    }


}

/////// 1
class HashMapMutableKey {

    @Data
    private static class MyKey {
        private int field1;
        private String field2;
    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void main(String[] args) {
        var key = new MyKey();
        key.setField1(1);
        key.setField2("val2");

        var keyDuplicate = new MyKey();
        keyDuplicate.setField1(1);
        keyDuplicate.setField2("val2");
        ////////////////////////////////////////////////

        var map = new HashMap<>();
        map.put(key, 1);
//        map.put(keyDuplicate, 1);

        print(key.equals(keyDuplicate));
        print("1) " + map.get(key));                        // 1
        print("2) " + map.get(keyDuplicate));               // 1
        ////////////////////////////////////////////////

        key.setField2("val2-edit");
        map.put(key, 1);
        print(map.size()); // 2
        map.remove(key);

        print(key.equals(keyDuplicate));
        print("3) " + map.get(key));                        // null
        print("4) " + map.get(keyDuplicate));               // null
        ////////////////////////////////////////////////

        key.setField2("val2");

        print("5) " + map.get(key));                        // 1
        print("6) " + map.get(keyDuplicate));               // 1
    }

}


/////// 2
class StreamReuse {

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void main(String[] args) {
        var stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        var filtered = stream.filter(integer -> integer > 2)
                .collect(Collectors.toList());
        print(filtered);                                    //

        var filtered1 = stream.filter(integer -> integer > 5)
                .collect(Collectors.toList());
        print(filtered1);                                   //
    }

}


/////// 3
class Multithread {

    public static void main(String[] args) throws InterruptedException {
//        Counter counter = new Counter();
        AtomicInteger counter = new AtomicInteger();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet();
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Count: " + counter.get());       //
    }

    public static class Counter {
        private int count = 0;

        public void increment() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }
}


////// 4
class SetSize {

    public static void main(String[] args) {
        Set<Person> people = new HashSet<>();
        Person person1 = new Person("Alice", 30);
        Person person2 = new Person("Alice", 30);

        people.add(person1);
        people.add(person2);

        System.out.println("Size: " + people.size());      /////
    }

    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Person person = (Person) obj;
            return age == person.age && name.equals(person.name);
        }


    }
}


//////// 5
class BufferedReaderClass {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("file.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


//////// 6
class Main {
    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable(getValue());

        if (optional.isPresent()) {
            System.out.println(optional.orElse(""));
        } else {
            System.out.println("Value is null");
        }
    }

    private static String getValue() {
        return null;
    }
}
