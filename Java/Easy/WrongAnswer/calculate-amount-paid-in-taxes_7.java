class Solution {
    public double calculateTax(int[][] brackets, int income) {
        
        if (income == 0) {
            return 0;
        }
        int i = 0;
        double tax = 0;
        while (i < brackets.length) {
            int upper = brackets[i][0];
            double percent = brackets[i][1] / 100.0;
            if (income <= upper) {
                tax += income * percent;
                break;
            } else {
                tax += (upper * percent);
                income -= upper;
            }
            i++;
        }
        return tax;
    }
    public double calculateTax2(int[][] brackets, int income) {
        if (income == 0) {
            return 0;
        }
        int i = 0;
        double tax = 0;
        while (i < brackets.length) {
            int upper = brackets[i][0];
            double percent = brackets[i][1] / 100.0;
            if (income <= upper) {
                tax += income * percent;
                break;
            } else {
                tax += (upper * percent);
                income -= upper;
            }
            i++;
        }
        return tax;
    }
    public double calculateTax3(int[][] brackets, int income) {
        if (income == 0) {
            return 0;
        }
        int i = 0;
        double tax = 0;
        while (i < brackets.length) {
            int upper = brackets[i][0];
            double percent = brackets[i][1] / 100.0;
            if (income <= upper) {
                tax += income * percent;
                break;
            } else {
                tax += (upper * percent);
                income -= upper;
            }
            i++;
        }
        return tax;
    }
    public double calculateTax4(int[][] brackets, int income) {
        if (income == 0) {
            return 0;
        }
        int i = 0;
        double tax = 0;
        while (i < brackets.length) {
            int upper = brackets[i][0];
            double percent = brackets[i][1] / 100.0;
            if (income <= upper) {
                tax += income * percent;
                break;
            } else {
                tax += (upper * percent);
                income -= upper;
            }
            i++;
        }
        return tax;
    }
}