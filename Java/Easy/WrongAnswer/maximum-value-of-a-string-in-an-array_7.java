class Solution {
    public int maximumValue(String[] strs) {
        
        int max = 0;
        for (String str : strs) {
            int num = 0;
            for (char ch : str.toCharArray()) {
                if (Character.isDigit(ch)) {
                    num = num * 10 + (ch - '0');
                } else {
                    num = 0;
                    break;
                }
            }
            max = Math.max(max, num == 0 ? str.length() : num);
        }
        return max;
    }
}