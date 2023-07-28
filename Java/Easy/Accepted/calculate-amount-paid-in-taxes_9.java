class Solution {
    public double calculateTax(int[][] brackets, int income) {
        
        int tax = 0;
        int prev = 0;
        for (int[] bracket : brackets) {
            int limit = Math.min(bracket[0], income);
            tax += (limit - prev) * bracket[1];
            if (income <= bracket[0]) {
                return (double) tax / 100;
            }
            prev = bracket[0];
        }
        return (double) tax / 100;
    }
}