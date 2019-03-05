package befaster.solutions.CHK;

import org.apache.commons.codec.binary.StringUtils;

public class CheckoutSolution {
    public Integer checkout(String skus) {

        int result = 0;

        if (skus == null) {
            return -1;
        }

        if (skus.isEmpty()) {
            return result;
        }

        int numberA = 0;

        int numberB = 0;

        int numberC = 0;
        int valC = 20;

        int numberD = 0;
        int valD = 15;

        int numberE = 0;

        int numberF = 0;

        int numberG = 0;
        int numberH = 0;
        int numberI = 0;
        int numberJ = 0;
        int numberK = 0;
        int numberL = 0;
        int numberM = 0;
        int numberN = 0;
        int numberO = 0;
        int numberP = 0;
        int numberQ = 0;
        int numberR = 0;
        int numberS = 0;
        int numberT = 0;
        int numberU = 0;
        int numberV = 0;
        int numberW = 0;
        int numberX = 0;
        int numberY = 0;
        int numberZ = 0;


        for (int i = 0; i < skus.length(); i++) {

            char c = skus.charAt(i);

            if (Character.isLowerCase(c)) {
                result = -1;
                System.out.println("Lower case");
                break;
            }

            switch (c) {
                case 'A':
                    numberA++;
                    break;
                case 'B':
                    numberB++;
                    break;
                case 'C':
                    numberC++;
                    break;
                case 'D':
                    numberD++;
                    break;
                case 'E':
                    numberE++;
                    break;
                case 'F':
                    numberF++;
                    break;
                default:
                    result = -1;
                    break;
            }
        }

        // PRELIM
        if (result == -1) {
            return result;
        }

        Strin

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




