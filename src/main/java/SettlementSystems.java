import java.util.ArrayList;
import java.util.Arrays;

public class SettlementSystems {
    private static final String ERROR_EMPTY_ARRAY = " ERROR! EMPTY_ARRAY! ";
    private static final String START_PARSING_ARR = ">>START_PARSING ARRAY = ";
    private static final String START_PARSING_ARR_TAG = "<<";
    private static final String END_PARSING_ARR = ">>END_PARSING<<";
    private static final String FLAG_CONTAIN_EQUALS = "+";
    private static final int COLUMN_STRING = 0;
    private static final int COLUMN_EQUAL_INDEX = 1;
    private static final int COLUMN_FLAG_EQUAL = 2;
    private static final int LEN_ALL_CHAR_ARRAY = 1500;
    private static final int COLUMN_COUNT = 3;
    private static final String FLAG_CONTINUE = ">";
    private static final String FLAG_NOW_IN_PROCESS = "-";
    private static final String FLAG_NO_INFO = "?";
    private static final String EQUAL_CHAR = " = ";
    private static final String DELIMITER = ", ";
    public ArrayList<String> findEqualsString (String [] arrString) {
        ArrayList<String> returnedList = new ArrayList<>();
        if (arrString == null || arrString.length == 0) {
            System.out.println(ERROR_EMPTY_ARRAY);
            returnedList.add(ERROR_EMPTY_ARRAY);
            return returnedList;
        }
        String [][] answer = new String[arrString.length][COLUMN_COUNT];
        System.out.println(START_PARSING_ARR + Arrays.toString(arrString) + START_PARSING_ARR_TAG);
        for (int i = 0; i < arrString.length; i++) {
            answer[i][COLUMN_STRING] = "\"" + arrString[i] + "\"";
            answer[i][COLUMN_EQUAL_INDEX] = EQUAL_CHAR + i;
            answer[i][COLUMN_FLAG_EQUAL] = FLAG_NOW_IN_PROCESS;
            for (int j = arrString.length - 1; j > i; j--) {
                if (answer[j][COLUMN_FLAG_EQUAL] == null) {
                    answer[j][COLUMN_FLAG_EQUAL] = FLAG_NO_INFO;
                }
                if (isContainEqualsChars(arrString[i], arrString[j]) && !answer[j][COLUMN_FLAG_EQUAL].equals(FLAG_CONTINUE)) {
                    String tmp = answer[i][COLUMN_EQUAL_INDEX] + DELIMITER + j;
                    answer[i][COLUMN_EQUAL_INDEX] = tmp;
                    answer[i][COLUMN_FLAG_EQUAL] = FLAG_CONTAIN_EQUALS;
                    answer[j][COLUMN_FLAG_EQUAL] = FLAG_CONTINUE;
                }
            }
        }
        printArray(answer);
        for (int i = 0; i < arrString.length; i++) {
            if (answer[i][COLUMN_FLAG_EQUAL] != null && answer[i][COLUMN_FLAG_EQUAL].equals(FLAG_CONTAIN_EQUALS)) {
                returnedList.add(answer[i][COLUMN_STRING] + answer[i][COLUMN_EQUAL_INDEX]);
            }
        }
        System.out.println(END_PARSING_ARR);
        return returnedList;
    }
    public boolean isContainEqualsChars (String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }
        int [] arrCharAsInt = new int[LEN_ALL_CHAR_ARRAY];
        char [] strAsArr1 = str1.toCharArray();
        char [] strAsArr2 = str2.toCharArray();
        for (int i = 0; i < strAsArr1.length; i++) {
            int charAsInt1 = strAsArr1[i];
            int charAsInt2 = strAsArr2[i];
            arrCharAsInt[charAsInt1] += 1;
            arrCharAsInt[charAsInt2] -= 1;
        }
        for (int i = 0; i < LEN_ALL_CHAR_ARRAY; i++) {
            if (arrCharAsInt[i] != 0) {
                return false;
            }
        }
        return true;
    }
    public void printArray(String [][] answer) {
        for (String[] strings : answer) {
            if (strings[COLUMN_FLAG_EQUAL] != null && strings[COLUMN_FLAG_EQUAL].equals(FLAG_CONTAIN_EQUALS)) {
                System.out.println(strings[COLUMN_STRING] + strings[COLUMN_EQUAL_INDEX]);
            }
        }
    }
}
