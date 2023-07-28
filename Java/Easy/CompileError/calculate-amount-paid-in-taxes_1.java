class Solution {
    public double calculateTax(int[][] brackets, int income) {
        
        double tax = 0.0;
        for (int i = 0; i < brackets.length; i++) {
            int upper = brackets[i][0];
            double percent = brackets[i][1] / 100.0;
            if (income <= upper) {
                tax += income * percent;
                break;
            }
            tax += upper * percent;
            income -= upper;
        }
        return tax;
    }
}
    }
}