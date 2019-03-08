package befaster.solutions.CHK;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class CheckoutSolution {
    public Integer checkout(String skus) {

        int result = 0;

        // Check 1
        if (skus == null || skus.equals("-")) {
            return -1;
        }
        // Check 2
        if (skus.isEmpty()) {
            return 0;
        }
        // Sanity 1
        for (int i = 0; i < skus.length(); i++) {
            if (Character.isLowerCase(skus.charAt(i))) {
                result = -1;
                break;
            }
        }
        // Sanity 2
        if (result == -1) {
            return result;
        }

        // TODO Refactor this
        int valC = 20;
        int valD = 15;
        int valG = 20;
        int valI = 35;
        int valJ = 60;
        int valL = 90;
        int valM = 15;
        int valO = 10;
        int valS = 30;
        int valT = 20;
        int valW = 20;
        int valX = 90;
        int valY = 10;
        int valZ = 50;

        int numberA = StringUtils.countMatches(skus, 'A');
        int numberB = StringUtils.countMatches(skus, 'B');
        int numberC = StringUtils.countMatches(skus, 'C');
        int numberD = StringUtils.countMatches(skus, 'D');
        int numberE = StringUtils.countMatches(skus, 'E');
        int numberF = StringUtils.countMatches(skus, 'F');
        int numberG = StringUtils.countMatches(skus, 'G');
        int numberH = StringUtils.countMatches(skus, 'H');
        int numberI = StringUtils.countMatches(skus, 'I');
        int numberJ = StringUtils.countMatches(skus, 'J');
        int numberK = StringUtils.countMatches(skus, 'K');
        int numberL = StringUtils.countMatches(skus, 'L');
        int numberM = StringUtils.countMatches(skus, 'M');
        int numberN = StringUtils.countMatches(skus, 'N');
        int numberO = StringUtils.countMatches(skus, 'O');
        int numberP = StringUtils.countMatches(skus, 'P');
        int numberQ = StringUtils.countMatches(skus, 'Q');
        int numberR = StringUtils.countMatches(skus, 'R');

        int numberU = StringUtils.countMatches(skus, 'U');
        int numberV = StringUtils.countMatches(skus, 'V');
        int numberW = StringUtils.countMatches(skus, 'W');

        int numberS = StringUtils.countMatches(skus, 'S');
        int numberT = StringUtils.countMatches(skus, 'T');
        int numberX = StringUtils.countMatches(skus, 'X');
        int numberY = StringUtils.countMatches(skus, 'Y');
        int numberZ = StringUtils.countMatches(skus, 'Z');


        // Simple rules
        int valCTotal = valC * numberC;
        int valDTotal = valD * numberD;
        int valGTotal = valG * numberG;
        int valITotal = valI * numberI;
        int valJTotal = valJ * numberJ;
        int valLTotal = valL * numberL;

        int valOTotal = valO * numberO;
        int valWTotal = valW * numberW;

        // Meh rules
        int valHTotal = 0;
        int valKTotal = 0;
        int valNTotal = 0;
        int valPTotal = 0;
        int valQTotal = 0;
        int valRTotal = 0;
        int valUTotal = 0;
        int valVTotal = 0;

        // A :: 5
        int discountedAby5 = numberA / 5; // Normalize
        int valADiscountedBy5 = discountedAby5 * 200;
        int notDiscountedAby5 = numberA - discountedAby5 * 5;
        // A :: 3
        int discountedAby3 = notDiscountedAby5 / 3;
        int valADiscountedBy3 = discountedAby3 * 130;
        // A :: Rest
        int notDiscountedA = numberA - discountedAby3 * 3 - discountedAby5 * 5;
        int valATotal = valADiscountedBy5 + valADiscountedBy3 + notDiscountedA * 50;

        // E
        int discountedBbyE = numberE / 2;
        int valETotal = numberE * 40;

        // B
        int valBTotal = 0;
        if(numberB != 0 ) {
            numberB = numberB - discountedBbyE;
            int discountedB = numberB / 2; // Normalize
            int notDiscountedB = numberB - discountedB * 2; // Rest
            int valBDiscounted = discountedB * 45;
            int valBNotDiscounted = notDiscountedB * 30;
            valBTotal = valBDiscounted + valBNotDiscounted;
        }

        // F
        int valFTotal = 0;
        if(numberF >= 3) {
            int discountedF = numberF / 3;
            valFTotal = numberF * 10;

            valFTotal = valFTotal - discountedF * 10;

        } else {
            valFTotal = numberF * 10;
        }

        // H - Same as A
        valHTotal = sameAsA(numberH, 10, 10, 80, 5, 45);
        // V - same as A
        valVTotal = sameAsA(numberV, 50, 3, 130, 2, 90);

        // K - same as B1
        valKTotal = sameAsB1(numberK, 2, 70, 120);
        // P - same as B1
        valPTotal = sameAsB1(numberP, 5, 50, 200);

        int discountedQbyR = numberR / 3;
        valRTotal = numberR * 50;

        // Q - same as B1
        if(numberQ != 0) {
            numberQ = numberQ - discountedQbyR;
            valQTotal = sameAsB1(numberQ, 3, 30, 80);
        }

        // N
        int discountedMbyN = numberN / 3;
        valNTotal = numberN * 40;

        // M
        int valMTotal = 0;
        if(numberM != 0) {
            numberM = numberM - discountedMbyN;
            valMTotal = numberM * valM;
        }

        // U
        if(numberU >= 4) {
            int discountedU= numberU / 4;
            valUTotal = numberU * 40;
            valUTotal = valUTotal - discountedU * 40;
        } else {
            valUTotal = numberU * 40;
        }

        /* Z > Y, S, T > X (last to be taken into account)
         There might be a formula for this
         Equivalent of adding up all and dividing by three
         Previous approach was bad. We can do better
        */

        skus = skus.replace("A", "");
        skus = skus.replace("B", "");
        skus = skus.replace("C", "");
        skus = skus.replace("D", "");
        skus = skus.replace("E", "");
        skus = skus.replace("F", "");
        skus = skus.replace("G", "");
        skus = skus.replace("H", "");
        skus = skus.replace("I", "");
        skus = skus.replace("J", "");
        skus = skus.replace("K", "");
        skus = skus.replace("L", "");
        skus = skus.replace("M", "");
        skus = skus.replace("N", "");
        skus = skus.replace("O", "");
        skus = skus.replace("P", "");
        skus = skus.replace("Q", "");
        skus = skus.replace("R", "");
        skus = skus.replace("U", "");
        skus = skus.replace("V", "");
        skus = skus.replace("W", "");

        char[] arrayOfSTXYZ = skus.toCharArray();
        ArrayList<Character> characters = new ArrayList<>();

        // Need something like XXXXX...STY...ZZZZZZ
        Arrays.sort(arrayOfSTXYZ);

        for(char c : arrayOfSTXYZ) {
            characters.add(c);
        }

        characters.sort(new ValueComparator());
        System.out.println(characters);

        Map<Character, Integer> mapOfValues = new HashMap<>();
        mapOfValues.put("S".charAt(0), 20);
        mapOfValues.put("T".charAt(0), 20);
        mapOfValues.put("X".charAt(0), 17);
        mapOfValues.put("Y".charAt(0), 20);
        mapOfValues.put("Z".charAt(0), 21);

        int discounted = characters.size() / 3;
        int remaining = characters.size() - discounted * 3;
        List<Character> finalCharacters = characters.subList(0, remaining);

        int valueFinalCharacters = 0;
        for(char c : finalCharacters) {
            valueFinalCharacters += mapOfValues.get(c);
        }

        System.out.println(discounted * 45);
        System.out.println(valueFinalCharacters);
        System.out.println(discounted * 45 + valueFinalCharacters);

        result =
                valATotal +
                        valBTotal +
                        valCTotal +
                        valDTotal +
                        valETotal +
                        valFTotal +
                        valGTotal +
                        valHTotal +
                        valITotal +
                        valJTotal +
                        valKTotal +
                        valLTotal +
                        valMTotal +
                        valNTotal +
                        valOTotal +
                        valPTotal +
                        valQTotal +
                        valRTotal +
                        valUTotal +
                        valVTotal +
                        valWTotal + discounted * 45 + valueFinalCharacters;

        return result;
    }

    public int sameAsA(int original, int originalValue,
                        int first, int firstValue,
                        int second, int secondValue) {
        // FIRST
        int discountedByFirst          = original / first; // Normalize
        int valDiscountedByFirst       = discountedByFirst * firstValue;
        int notDiscountedByFirst       = original - discountedByFirst * first;
        // SECOND
        int discountedBySecond         = notDiscountedByFirst / second;
        int valDiscountedBySecond      = discountedBySecond * secondValue;
        // REST
        int notDiscounted               = original -
                discountedBySecond * second -
                discountedByFirst * first;

        return valDiscountedByFirst + valDiscountedBySecond + notDiscounted * originalValue;
    }

    public int sameAsB1(int original, int quota, int originalValue, int discount){

        int discounted          = original / quota; // Normalize
        int notDiscounted      = original - discounted * quota; // Rest
        int valDiscounted      = discounted * discount;
        int valNotDiscounted   = notDiscounted * originalValue;

        return valDiscounted + valNotDiscounted;
    }

    class ValueComparator implements Comparator<Character> {

        @Override
        public int compare(Character o1, Character o2) {
            if(o1 == 'X') {
                return -1;
            } else if (o1 == 'Z')
                return 1;
            else
                return 0;
        }
    }

    public static void main(String[] args) {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        System.out.println(checkoutSolution.checkout("STXZ"));
    }
}

