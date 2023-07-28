class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        
        // 1. convert num to string
        // 2. reverse the string
        // 3. convert the reversed string to int
        // 4. add the num and reversed num and check if the sum is equal to num
        String numString = Integer.toString(num);
        String reverseNumString = new StringBuffer(numString).reverse().toString();
        int reverseNum = Integer.parseInt(reverseNumString);
        if (num + reverseNum == num) {
            return true;
        }
        return false;
    }
}