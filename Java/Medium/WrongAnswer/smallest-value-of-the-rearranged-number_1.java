class Solution {
    public long smallestNumber(long num) {
        
        if (num < 0) {
            return -smallestNumber(-num);
        }
        char[] digits = Long.toString(num).toCharArray();
        Arrays.sort(digits);
        long result = 0;
        for (char digit : digits) {
            result = result * 10 + digit - '0';
        }
        return result;
    }
}