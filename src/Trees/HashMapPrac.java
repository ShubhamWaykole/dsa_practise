package Trees;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

public class HashMapPrac {
    public static void main(String[] args) {
        HashMapPrac obj = new HashMapPrac();
        obj.execute();
    }

    public void execute() {
        HashMap<String, Employee> map = new HashMap();
        Employee e1 = new Employee("shubham");
        Employee e2 = new Employee("shubham1");
        map.put(e1.name,e1);
        map.put(e1.name,e2);
        Employee entry = map.get("shubham");
        System.out.println(entry);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class Employee {
        private String name;

        @Override
        public boolean equals(Object o) {
            return true;
        }

        @Override
        public int hashCode() {
            return 1;
        }
    }
}
