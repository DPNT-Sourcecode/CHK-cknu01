package befaster.solutions.CHK;

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
        int valA = 50;

        int numberB = 0;
        int valB = 30;

        int numberC = 0;
        int valC = 20;

        int numberD = 0;
        int valD = 15;

        int numberE = 0;
        int valE = 40;

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
                default:
                    result = -1;
                    break;
            }
        }

        if (result == -1) {
            return result;
        }

        System.out.println(numberA);
        System.out.println(numberB);
        System.out.println(numberC);
        System.out.println(numberD);

        // C, D are easy since they don't get discounted
        int valCTotal = valC * numberC;
        int valDTotal = valD * numberD;

        // A :: 5
        int discountedAby5 = numberA / 5; // Normalize
        int valADiscountedBy5 = discountedAby5 * 200;

        int notDiscountedAby5 = numberA - discountedAby5 * 5;
        // A :: 3
        int discountedAby3 = notDiscountedAby5 / 3;
        int valADiscountedBy3 = discountedAby3 * 3;
        // A :: Rest
        int notDiscountedA = numberA - discountedAby3 - discountedAby5;
        int valATotal = valADiscountedBy5 + valADiscountedBy3 + notDiscountedA * 50;

        // E
        int discountedBbyE = numberE / 2;
        int valETotal = numberE * 40;

        // B
        numberB = numberB - discountedBbyE;
        int discountedB = numberB / 2; // Normalize
        int notDiscountedB = numberB - discountedB * 2; // Rest
        int valBDiscounted = discountedB * 45;
        int valBNotDiscounted = notDiscountedB * 30;
        int valBTotal = valBDiscounted + valBNotDiscounted;

        result = valATotal + valBTotal + valCTotal + valDTotal + valETotal;


        return result;
    }

    public static void main(String[] args) {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        checkoutSolution.checkout("AAA");
    }
}



