class Solution {
    public int secondHighest(String s) {
        
        int max = -1;
        int secondMax = -1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int digit = Character.getNumericValue(s.charAt(i));
                if (digit > max) {
                    secondMax = max;
                    max = digit;
                } else if (digit > secondMax && digit != max) {
                    secondMax = digit;
                }
            }
        }
        return secondMax;
    }
}