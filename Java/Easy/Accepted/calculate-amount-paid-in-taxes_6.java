class Solution {
    public double calculateTax(int[][] brackets, int income) {
        
        double tax = 0;
        int prev = 0;
        for (int i = 0; i < brackets.length; i++) {
            int[] bracket = brackets[i];
            int upper = bracket[0];
            int percent = bracket[1];
            int earned = Math.min(upper, income) - prev;
            tax += earned * percent / 100.0;
            prev = upper;
            if (income <= upper) break;
        }
        return tax;
    }
}