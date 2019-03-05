package befaster.solutions.CHK;

public class CheckoutSolution {
    public Integer checkout(String skus) {

        int result = 0;

        if(skus == null || skus.isEmpty()) {
            return -1;
        }

        int numberA = 0;
        int valA = 50;
        int numberB = 0;
        int valB = 30;
        int numberC = 0;
        int valC = 20;
        int numberD = 0;
        int valD = 15;

        for(int i = 0; i < skus.length(); i++) {
            char c = skus.charAt(0);

            switch (c) {
                case 'A' :
                    numberA++;
                    break;
                case 'B' :
                    numberB++;
                    break;
                case 'C' :
                    numberC++;
                    break;
                case 'D' :
                    numberD++;
                    break;
                default:
                    result = -1;
                    break;
            }

            if(result == -1) {
                break;
            } else {
                System.out.println(numberA);
                System.out.println(numberB);
                System.out.println(numberC);
                System.out.println(numberD);

                // C, D are easy since they don't get discounted
                int valCTotal = valC * numberC;
                int valDTotal = valD * numberD;

                int discountedA = numberA / 3; // Normalize
                int notDiscountedA = numberA - discountedA; // Rest
                int valADiscounted = (discountedA / 3) * 130;
                int valANotDiscounted = notDiscountedA * 50;
                int valATotal = valADiscounted + valANotDiscounted;

                int discountedB = numberB / 2; // Normalize
                int notDiscountedB = numberB - discountedB; // Rest
                int valBDiscounted = (discountedB / 2) * 45;
                int valBNotDiscounted = notDiscountedB * 30;
                int valBTotal = valBDiscounted + valBNotDiscounted;

                result = valATotal + valBTotal + valCTotal + valDTotal;

            }
        }

        return result;
    }
}
