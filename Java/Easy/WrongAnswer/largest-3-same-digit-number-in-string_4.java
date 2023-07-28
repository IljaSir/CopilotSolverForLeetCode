class Solution {
    public String largestGoodInteger(String num) {
        
        int[] counts = new int[10];
        for (char c : num.toCharArray()) {
            counts[c - '0']++;
        }
        for (int i = 9; i >= 0; i--) {
            if (counts[i] >= 3) {
                return String.valueOf(i) + String.valueOf(i) + String.valueOf(i);
            }
        }
        return "";
    }
}