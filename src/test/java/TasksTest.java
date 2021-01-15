import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TasksTest {
    //===============================================Task 1======================================
    Tasks tasks = new Tasks();
    private final static int[] array1 = {-8, 0, 1, -123, 8, 9, 10};
    private final static int[] array2 = {23, 0, 1, 6, 8, 9, 1050};
    private final static int[] array3 = {5, 2, 3, 4, 2, 5, 1, 7};
    private final static int[] array4 = {-293};
    private final static int[] array5 = {};

    private final static int[] sortedArray1 = {-123, -8, 0, 1, 8, 9, 10};
    private final static int[] sortedArray2 = {0, 1, 6, 8, 9, 23, 1050};
    private final static int[] sortedArray3 = {1, 2, 2, 3, 4, 5, 5, 7};
    private final static int[] sortedArray4 = {-293};
    private final static int[] sortedArray5 = {};


    static Stream<Arguments> sortArrayUsingBubbleSort_NOMINAL() {
        return Stream.of(
                arguments(array1, sortedArray1),
                arguments(array2, sortedArray2),
                arguments(array3, sortedArray3),
                arguments(array4, sortedArray4),
                arguments(array5, sortedArray5)
        );
    }
    @ParameterizedTest
    @MethodSource("sortArrayUsingBubbleSort_NOMINAL")
    void sortArrayUsingBubbleSortTest(int[] array, int [] expected) {
        int[] actual = tasks.sortArrayUsingBubbleSort(array);
        Assertions.assertArrayEquals(expected,actual);
    }
    //===============================================Task 2======================================
    static Stream<Arguments> searchNumberUsingBinaryMethod1Test_NOMINAL() {
        return Stream.of(
                arguments(array1, -123, -123),
                arguments(array2, 7, 8),
                arguments(array3, 5, 5),
                arguments(array4, -293, -293),
                arguments(array5, 500, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("searchNumberUsingBinaryMethod1Test_NOMINAL")
    void searchNumberUsingBinaryMethod1Test(int[] array, int number, int expected) {
        int actual = tasks.searchNumberUsingBinaryMethod1(array, number);
        Assertions.assertEquals(expected, actual);
    }
    //===============================================Task 3======================================

    //===============================================Task 3======================================

    //Test on task3
    //Test on task4
    //Test on task5
    //Test on task6
    //Test on task7
    //Test on task8
    //Test on task9
    //===============================================Task 9======================================
    static Stream<Arguments> isHexTest() {
        return Stream.of(
                arguments("77",true),
                arguments("FF",true),
                arguments("0  111",false),
                arguments("",false),
                arguments("AA",true),
                arguments("aasdadsa asd asd daaw",false),
                arguments("55",true)

        );
    }

    @ParameterizedTest(name = "Is hex. Input data is {0}, {1} ")
    @MethodSource("isHexTest")
    void isHexTest_0(String phoneNumber, boolean expected) {
        boolean actual = tasks.isHex(phoneNumber);
        assertEquals(expected, actual);
    }
    @Test
    public void isHexTest_exception() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            tasks.isHex(null);
        }, "Empty string.");
    }
    //===============================================Task 10======================================
    static Stream<Arguments> isItPhoneNumberTest() {
        return Stream.of(
                arguments("+380 (95) 666-88-99",true),
                arguments("+380 (66) 111-00-44",true),
                arguments("0",false),
                arguments("+02",false),
                arguments("+7 (896) 666-88-99",true),
                arguments("aasdadsa asd asd daaw",false),
                arguments("+0404 (998) 123-83-49",true)

        );
    }

    @ParameterizedTest(name = "is It Phone Number. Input data is {0}, {1} ")
    @MethodSource("isItPhoneNumberTest")
    void isItPhoneNumberTest_0(String phoneNumber, boolean expected) {
        boolean actual = tasks.isPhoneNumber(phoneNumber);
        assertEquals(expected, actual);
    }
    @Test
    public void isPhoneNumberTest_exception() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            tasks.isPhoneNumber(null);
        }, "Empty string.");
    }
    //Test on task11
}