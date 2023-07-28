class Solution {
    public int countDigits(int num) {
        
        int count = 0;
        String number = Integer.toString(num);
        for (char c : number.toCharArray()) {
            int digit = Character.getNumericValue(c);
            if (digit != 0 && num % digit == 0) {
                count++;
            }
        }
        return count;
    }
}