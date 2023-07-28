class Solution {
    public double calculateTax(int[][] brackets, int income) {
        
        double res = 0;
        int i = 0;
        while (income > 0) {
            int tax = Math.min(income, brackets[i][0]);
            res += tax * brackets[i][1] / 100.0;
            income -= tax;
            i++;
        }
        return res;
    }
}