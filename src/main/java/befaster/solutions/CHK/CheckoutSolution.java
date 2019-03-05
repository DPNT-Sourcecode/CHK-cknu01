package befaster.solutions.CHK;

import org.apache.commons.lang3.StringUtils;

public class CheckoutSolution {
    public Integer checkout(String skus) {

        int result = 0;

        if (skus == null) {
            return -1;
        }

        if (skus.isEmpty()) {
            return 0;
        }

        for (int i = 0; i < skus.length(); i++) {
            if (Character.isLowerCase(skus.charAt(i))) {
                result = -1;
                break;
            }
        }

        // PRELIM
        if (result == -1) {
            return result;
        }

        int valC = 20;
        int valD = 15;

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
        

        // C, D are easy since they don't get discounted
        int valCTotal = valC * numberC;
        int valDTotal = valD * numberD;

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


        int valFTotal = 0;
        if(numberF >= 3) {
            int discountedF = numberF / 3;
            valFTotal = numberF * 10;

            valFTotal = valFTotal - discountedF * 10;

        } else {
            valFTotal = numberF * 10;
        }

        result = valATotal + valBTotal + valCTotal + valDTotal + valETotal + valFTotal;

        return result;
    }

    public static void main(String[] args) {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        System.out.println(checkoutSolution.checkout("FFFF"));
    }
}
