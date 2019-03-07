package befaster.solutions.CHK;

import org.apache.commons.lang3.StringUtils;

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

        // Z > Y, S, T > X (last to be taken into account)
        // There might be a formula for this
        // Equivalent of adding up all and dividing by three

        int discountedX = numberX / 3;
        int remainingX = numberX - discountedX * 3;

        int discountedZ = numberZ / 3;
        int remainingZ = numberZ - discountedZ * 3;

        int discountYST = (numberS + numberY + numberT) / 3;
        int remainingYST = (numberS + numberY + numberT) - discountYST * 3;

        int discountedGroup = (discountYST + discountedX + discountedZ) * 45;
        int remainingGroup = remainingYST + remainingX + remainingZ;
        int discountedRemaining = remainingGroup / 3;
        int finalRemaining = remainingGroup - discountedRemaining * 3;

        int sumTotalGroup;
        if(remainingYST + remainingX + remainingZ < 3) {
            sumTotalGroup = remainingYST * 20 + remainingZ * 21 + remainingX * 17;
        } else {
            sumTotalGroup = discountedGroup + discountedRemaining * 45 + finalRemaining * 17;
        }

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
                        valWTotal +
                        sumTotalGroup;

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

    public static void main(String[] args) {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        System.out.println(checkoutSolution.checkout("SSS"));
    }
}


