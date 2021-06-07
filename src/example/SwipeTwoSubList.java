package example;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SwipeTwoSubList {

    public static void main(String[] args) {
        var numbers = new ArrayList<Integer>(100);
        for (var i = 0; i <= 40; i++) {
            numbers.add(i);
        }
        numbers
                = (ArrayList<Integer>) numbers.stream()
                        .sorted((n1, n2) -> {
                            if (((n1 >= 20) && (n2 >= 20)) || ((n1 <= 20) && (n2 <= 20))) {
                                return n1 - n2;
                            } else {
                                return n2 - n1;
                            }
                        }).collect(Collectors.toList());
        numbers.forEach(number -> {
            System.out.println(number);
        });
    }

}
