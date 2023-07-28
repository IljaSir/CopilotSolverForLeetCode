class Solution {
    public int maximumValue(String[] strs) {
        
        int max = 0;
        for(String s : strs) {
            int value = 0;
            for(int i = 0; i < s.length(); i++) {
                if(Character.isDigit(s.charAt(i))) {
                    value = value * 10 + (s.charAt(i) - '0');
                } else {
                    value = s.length();
                    break;
                }
            }
            max = Math.max(max, value);
        }
        return max;
    }
}