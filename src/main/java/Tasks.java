import java.math.BigInteger;
import java.util.regex.Pattern;

public class Tasks {

    //Task 1
    public int[] sortArrayUsingBubbleSort(int[] array) {
        if (array.length == 1) {
            return array;
        }
        if (array.length < 2) {
            return new int[0];
        }
        int numberCounter, number, saveNumber;
        for (numberCounter = 0; numberCounter < array.length; numberCounter++) {
            for (number = 0; number < array.length - numberCounter - 1; number++) {
                if (array[number] > array[number + 1]) {
                    saveNumber = array[number];
                    array[number] = array[number + 1];
                    array[number + 1] = saveNumber;
                }
            }
        }
        return array;
    }

    //Task2
    public int searchNumberUsingBinaryMethod1(int[] array, int number) {
        if (array.length < 1) {
            return 0;
        }
        array = sortArrayUsingBubbleSort(array);
        int start = 0, end = array.length - 1, mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (array[mid] == number) {
                return array[mid];
            }
            if (array[mid] < number) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return array[mid] > number ? array[mid - 1] : array[mid + 1];
    }

    //Task3
    public int searchNumberUsingBinaryMethod2(int[] arr, int num) {
        int indexOfNum = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) return indexOfNum;
        }
        for (int i = (arr.length / 2) - 1; i >= 0; i--) {
            if (num == arr[i]) {
                return i;
            }
            for (int j = arr.length / 2; j > arr.length - 1; j++) {
                if (num == arr[j]) {
                    return j;
                }
            }
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == num + 1) {
                return i;
            } else if (arr[i] == num - 1) {
                return i;
            }
        }
        return indexOfNum;
    }

    //Task4
    public boolean isAllBitsSelected(long number, byte[] bitPositions) {
        String str = Long.toBinaryString(number);
        StringBuilder sb = new StringBuilder(str);
        if (str.length() <= 7) {
            int length = 7 - str.length();
            for (int i = 0; i < length; i++)
                sb.insert(0, 0);
        }
        for (int i = 0; i < bitPositions.length; i++) {
            if (sb.charAt(bitPositions[i]) != 49) {
                return false;
            }
        }
        return true;
    }

    //Task5
    public boolean isAnyBitSelected(long number, byte[] bitPositions) {
        String str = Long.toBinaryString(number);
        StringBuilder sb = new StringBuilder(str);
        if (str.length() <= 7) {
            int length = 7 - str.length();
            for (int i = 0; i < length; i++)
                sb.insert(0, 0);
        }
        for (int i = 0; i < bitPositions.length; i++) {
            if (sb.charAt(bitPositions[i]) == 49) {
                return true;
            }
        }
        return false;
    }

    //Task6
    public String selectAnyBitSelected(long number, byte[] bitPositions) {
        String str = Long.toBinaryString(number);
        StringBuilder sb = new StringBuilder(str);
        if (str.length() <= 7) {
            int length = 7 - str.length();
            for (int i = 0; i < length; i++)
                sb.insert(0, 0);
        }
        for (int i = 0; i < bitPositions.length - 1; i++) {
            for (int j = 0; j < sb.length() - 1; j++) {
                if (sb.charAt(bitPositions[i]) != 49) {
                    sb.insert(bitPositions[i], 1).deleteCharAt(bitPositions[i] + 1);
                }
            }

        }
        return sb.toString();
    }

    //Task7
    public String deselectAnyBitSelected(long number, byte[] bitPositions) {
        String str = Long.toBinaryString(number);
        StringBuilder sb = new StringBuilder(str);
        if (str.length() <= 7) {
            int length = 7 - str.length();
            for (int i = 0; i < length; i++)
                sb.insert(0, 0);
        }
        for (int i = 0; i < bitPositions.length - 1; i++) {
            for (int j = 0; j < sb.length() - 1; j++) {
                if (sb.charAt(bitPositions[i]) != 49) {
                    sb.insert(bitPositions[i], 0).deleteCharAt(bitPositions[i] + 1);
                }
            }

        }
        return sb.toString();
    }

    //Task 8
    public long invertBit(long numb, int position) {
        String binary = Long.toBinaryString(numb);
        char[] oneAndZero = binary.toCharArray();
        if (numb == 0) {
            return 0;
        } else if ((position > binary.length() - 1)) {
            System.out.println("Такой позиции не существует");
            return numb;
        }
        if (oneAndZero[position] == '0') {
            oneAndZero[position] = '1';
        } else {
            oneAndZero[position] = '0';
        }
        return new BigInteger(String.valueOf(oneAndZero), 2).longValue();
    }

    //Task9
    public boolean isHex(String input) {
        final Pattern REGEX_PATTERN = Pattern.compile("^\\p{XDigit}+$");
        if (REGEX_PATTERN.matcher(input).matches()) {
            return true;
        } else {
            return false;
        }
    }
    //Task10
    public final static String regexForPhoneNumber = "^(\\+\\d{1,4}( )?)?((\\(\\d{1,3}\\))( )\\d{3})(-)?\\d{2}(-)?\\d{2}$";
    public boolean isPhoneNumber(String numb) {
        if (numb == null){
            throw new IllegalArgumentException("Empty string.");
        }
        return numb.matches(regexForPhoneNumber);
    }
    //Task11
}
