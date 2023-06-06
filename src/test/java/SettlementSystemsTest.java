import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SettlementSystemsTest {
    SettlementSystems settlementSystems = new SettlementSystems();
    @Test
    public void findEqualsStringAllStringIsEmpty() {
        String [] test = new String[]{"","","","","","",""};
        String actualAnswerAsString = settlementSystems.findEqualsString(test).toString();
        String expectedAnswerAsString = "[ = 0, 6, 5, 4, 3, 2, 1]";
        Assert.assertEquals(expectedAnswerAsString, actualAnswerAsString);
    }
    @Test
    public void findEqualsStringNormalData() {
        String [] test = new String[]{"a","aa","a","qwe","qwe","qwwe","q","a","aa","a","qwe","qwe","qwwe","q","a","aa","a","qwe","qwe","qwwe","q"};
        String actualAnswerAsString = settlementSystems.findEqualsString(test).toString();
        String expectedAnswerAsString = "[a = 0, 16, 14, 9, 7, 2, aa = 1, 15, 8, qwe = 3, 18, 17, 11, 10, 4, qwwe = 5, 19, 12, q = 6, 20, 13]";
        Assert.assertEquals(expectedAnswerAsString, actualAnswerAsString);
    }
    @Test
    public void findEqualsStringNormalData2() {
        String [] test = new String[]{"a","aa","a","qwe","qwe","qwwe","q","a","aa","a","qwe","ewq","qwwe","q","a","aa","a","qwe","qwe","qwwe","q"};
        String actualAnswerAsString = settlementSystems.findEqualsString(test).toString();
        String expectedAnswerAsString = "[a = 0, 16, 14, 9, 7, 2, aa = 1, 15, 8, qwe = 3, 18, 17, 11, 10, 4, qwwe = 5, 19, 12, q = 6, 20, 13]";
        Assert.assertEquals(expectedAnswerAsString, actualAnswerAsString);
    }
    @Test
    public void findEqualsStringNormalData3() {
        String [] test = new String[]{"a","aa","a","wasd","wdsa","wa","q","a","aa","a","qwe","ewq","qwwe","q","a","ewqw","a","qwe","qwe","qwwe","q"};
        String actualAnswerAsString = settlementSystems.findEqualsString(test).toString();
        String expectedAnswerAsString = "[a = 0, 16, 14, 9, 7, 2, aa = 1, 8, wasd = 3, 4, q = 6, 20, 13, qwe = 10, 18, 17, 11, qwwe = 12, 19, 15]";
        Assert.assertEquals(expectedAnswerAsString, actualAnswerAsString);
    }
    @Test
    public void findEqualsStringWithDigits() {
        String [] test = new String[]{"a","123","a","wasd","wdsa","wa","231","a","aa","a","qwe","ewq","qwwe","q","a","ewqw","a","213","qwe","qwwe","q"};//qwe->ewq
        String actualAnswerAsString = settlementSystems.findEqualsString(test).toString();
        String expectedAnswerAsString = "[a = 0, 16, 14, 9, 7, 2, 123 = 1, 17, 6, wasd = 3, 4, qwe = 10, 18, 11, qwwe = 12, 19, 15, q = 13, 20]";
        Assert.assertEquals(expectedAnswerAsString, actualAnswerAsString);
    }
    @Test
    public void findEqualsStringEmptyArray() {
        String [] test = new String[]{};
        String actualAnswerAsString = settlementSystems.findEqualsString(test).toString();
        String expectedAnswerAsString = "[ ERROR! EMPTY_ARRAY! ]";
        Assert.assertEquals(expectedAnswerAsString, actualAnswerAsString);
    }
    @Test
    public void findEqualsStringNullArray() {
        String [] test = null;
        String actualAnswerAsString = settlementSystems.findEqualsString(test).toString();
        String expectedAnswerAsString = "[ ERROR! EMPTY_ARRAY! ]";
        Assert.assertEquals(expectedAnswerAsString, actualAnswerAsString);
    }
    @Test
    public void findEqualsStringNormalDataAndEmptyString() {
        String [] test = new String[]{"a","aa","","qwe","qwe","","q","a","aa","","qwe","","qwwe","","a","aa","a","qwe","qwe","qwwe","q"};
        String actualAnswerAsString = settlementSystems.findEqualsString(test).toString();
        String expectedAnswerAsString = "[a = 0, 16, 14, 7, aa = 1, 15, 8,  = 2, 13, 11, 9, 5, qwe = 3, 18, 17, 10, 4, q = 6, 20, qwwe = 12, 19]";
        Assert.assertEquals(expectedAnswerAsString, actualAnswerAsString);
    }
    @Test
    public void findEqualsStringSpecialSymbols() {
        String [] test = new String[]{"a","123","a","wasd","z-x-a-0/*!@#$%^&*()","wa","231","a","aa","/*!@#$%^&*()0-a-z-x","qwe","ewq","qwwe","q","a","ewqw","a","213","qwe","qwwe","q"};
        String actualAnswerAsString = settlementSystems.findEqualsString(test).toString();
        String expectedAnswerAsString = "[a = 0, 16, 14, 7, 2, 123 = 1, 17, 6, z-x-a-0/*!@#$%^&*() = 4, 9, qwe = 10, 18, 11, qwwe = 12, 19, 15, q = 13, 20]";
        Assert.assertEquals(expectedAnswerAsString, actualAnswerAsString);
    }
    @Test
    public void findEqualsStringRussianLetters() {
        String [] test = new String[]{"л","аа","ф","аопр","рп","","нгок","ф","аа","й","одл","","лод","","л","рпоа","а","апр","пра","когн","й"};
        String actualAnswerAsString = settlementSystems.findEqualsString(test).toString();
        String expectedAnswerAsString = "[л = 0, 14, аа = 1, 8, ф = 2, 7, аопр = 3, 15,  = 5, 13, 11, нгок = 6, 19, й = 9, 20, одл = 10, 12, апр = 17, 18]";
        Assert.assertEquals(expectedAnswerAsString, actualAnswerAsString);
    }
}