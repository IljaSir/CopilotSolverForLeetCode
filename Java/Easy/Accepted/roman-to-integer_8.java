class Solution {
    public int romanToInt(String s) {
        
        int result = 0;
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = getValue(s.charAt(i));
            if (current > prev) {
                result += current - 2 * prev;
            } else {
                result += current;
            }
            prev = current;
        }
        return result;
    }
    
    private int getValue(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}