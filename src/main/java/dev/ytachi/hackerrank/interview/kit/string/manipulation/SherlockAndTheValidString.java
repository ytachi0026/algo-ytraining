package dev.ytachi.hackerrank.interview.kit.string.manipulation;

import java.util.Arrays;

/**
 * Sherlock and the Valid String
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings&h_r=next-challenge&h_v=zen
 */
public class SherlockAndTheValidString {
    public static void main(String[] args) {
        // It should be YES
        final String response = isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd");
        System.out.println(response);
    }



    // Complete the isValid function below.
    // yeah I love sherlock problems
    static String isValid(String s) {
        long[] ocurrences = new long[26]; // since the problem states S[i] belongs to asccis [a-z]

        // lets calcula te the frequency of each S character
        for (int i = 0; i < s.length(); i++) {
            ocurrences[s.charAt(i) - 'a']++;
        }
        // think about it, you can delete, but not add, if we order this, we will be good
        // Or you can just don't order it, since you need to delete 1!

        long currentFrequency = -1;
        boolean removedChar = false;
        // lets analyse it
        for (int i = 0; i < 26; i++) {
            if (ocurrences[i] == 0) {
                continue;
            } else {
                if (currentFrequency == -1) {
                    currentFrequency = ocurrences[i]; // lets assume this is gonna be the default frequency, since it is the lower one.
                    continue;
                } else if (currentFrequency == ocurrences[i]) {
                        continue;
                    } else if (!removedChar && Math.abs(ocurrences[i] - currentFrequency) == 1) {
                        removedChar = true;
                        continue;
                    } else {
                    return "NO";
                }
            }
        }
        return "YES";
    }
}
