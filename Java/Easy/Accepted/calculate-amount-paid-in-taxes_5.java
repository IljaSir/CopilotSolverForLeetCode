class Solution {
    public double calculateTax(int[][] brackets, int income) {
        
        double tax = 0;
        int prev = 0;
        for(int i = 0; i < brackets.length; i++) {
            int upper = brackets[i][0];
            int percent = brackets[i][1];
            if(income >= upper) {
                tax += (upper - prev) * percent / 100.0;
                prev = upper;
            } else {
                tax += (income - prev) * percent / 100.0;
                break;
            }
        }
        return tax;
    }
}