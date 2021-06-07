/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import java.util.function.IntBinaryOperator;

/**
 *
 *
 * @author Cat
 */
public class MathematicalOperatorInParameter {

    public static void main(String[] args) {
        IntBinaryOperator addition = (a, b) -> a + b;
        IntBinaryOperator subtraction = (a, b) -> a - b;
        System.out.println(addition_or_subtraction(100, 50, addition));
        System.out.println(addition_or_subtraction(100, 50, subtraction));
    }

    public static int addition_or_subtraction(int number, int number2, IntBinaryOperator binaryOperator) {
        return binaryOperator.applyAsInt(number, number2);
    }
}
