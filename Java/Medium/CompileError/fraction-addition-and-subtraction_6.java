class Solution {
    public String fractionAddition(String expression) {
        
        String[] fractions = expression.split("(?=[-+])");
        int numerator = 0;
        int denominator = 1;
        for(String fraction : fractions){
            int[] fractionNums = getFractionNums(fraction);
            numerator = numerator * fractionNums[1] + denominator * fractionNums[0];
            denominator *= fractionNums[1];
            int gcd = gcd(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;
        }
        return numerator + "/" + denominator;
    }
    
    private int[] getFractionNums(String fraction){
        String[] nums = fraction.split("/");
        int numerator = Integer.parseInt(nums[0]);
        int denominator = Integer.parseInt(nums[1]);
        return new int[]{numerator, denominator};
    }
}