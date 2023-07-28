class Solution {
    public double calculateTax(int[][] brackets, int income) {
        
        double tax = 0;
        for (int i = 0; i < brackets.length; i++) {
            int upper = brackets[i][0];
            int percent = brackets[i][1];
            if (income <= upper) {
                tax += income * percent / 100.0;
                break;
            } else {
                tax += (upper - (i == 0 ? 0 : brackets[i-1][0])) * percent / 100.0;
            }
        }
        return tax;
    }
}