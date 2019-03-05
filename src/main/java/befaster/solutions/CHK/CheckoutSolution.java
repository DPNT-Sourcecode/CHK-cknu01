package befaster.solutions.CHK;

import org.apache.commons.lang3.StringUtils;

public class CheckoutSolution {
    public Integer checkout(String skus) {

        int result = 0;

        // Check 1
        if (skus == null) {
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
        int numberS = StringUtils.countMatches(skus, 'S');
        int numberT = StringUtils.countMatches(skus, 'T');
        int numberU = StringUtils.countMatches(skus, 'U');
        int numberV = StringUtils.countMatches(skus, 'V');
        int numberW = StringUtils.countMatches(skus, 'W');
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
        int valSTotal = valS * numberS;
        int valTTotal = valT * numberT;
        int valWTotal = valW * numberW;
        int valXTotal = valX * numberX;
        int valYTotal = valY * numberY;
        int valZTotal = valZ * numberZ;

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
        if(numberB != 0) {
            numberB = numberB - discountedBbyE;
            int discountedB = numberB / 2; // Normalize
            int notDiscountedB = numberB - discountedB * 2; // Rest
            int valBDiscounted = discountedB * 45;
            int valBNotDiscounted = notDiscountedB * 30;
            valBTotal = valBDiscounted + valBNotDiscounted;
        }

        // F
        int valFTotal;
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
        valKTotal = sameAsB1(numberV, 2, 80, 150);
        // P - same as B1
        valPTotal = sameAsB1(numberP, 5, 50, 200);

        int discountedQbyR = numberQ / 3;
        valRTotal = numberR * 50;

        // Q - same as B1
        valQTotal = sameAsB1(numberQ, 3, 30, 80);

        // N
        int discountedMbyN = numberN / 3;
        valNTotal = numberN * 40;

        // M
        int valMTotal = 0;
        if(numberM != 0) {
            numberM = numberM - discountedMbyN;
            valMTotal = numberM * valM;
        }
        result =
                valATotal +
                valBTotal +
                valCTotal +
                valDTotal +
                valETotal +
                valFTotal ;

        return result;
    }

    public int sameAsA(int original, int originalValue,
                        int first, int firstValue,
                        int second, int secondValue) {
        // FIRST
        int discountedByFirst          = original / first; // Normalize
        int valDiscountedByFirst       = discountedByFirst * firstValue;
        int notDiscountedByFirst       = original - discountedByFirst * 5;
        // SECOND
        int discountedBySecond         = notDiscountedByFirst / second;
        int valDiscountedBySecond      = discountedBySecond * secondValue;
        // REST
        int notDiscounted               = original -
                discountedBySecond * secondValue -
                discountedByFirst * firstValue;

        return valDiscountedByFirst + valDiscountedBySecond + notDiscounted * originalValue;
    }

    public int sameAsB1(int original, int quota, int originalValue, int discount){

        int discounted          = original / quota; // Normalize
        int notDiscounted      = original - discounted * quota; // Rest
        int valDiscounted      = discounted * discount;
        int valNotDiscounted   = notDiscounted * originalValue;

        return valDiscounted + valNotDiscounted;
    }

    public static void main(String[] args) {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        System.out.println(checkoutSolution.checkout("FFFF"));
    }
}
