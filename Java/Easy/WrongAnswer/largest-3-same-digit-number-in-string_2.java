class Solution {
    public String largestGoodInteger(String num) {
        
        int[] count = new int[10];
        for (char c : num.toCharArray()) {
            count[c - '0']++;
        }
        for (int i = 9; i >= 0; i--) {
            if (count[i] >= 3) {
                return "" + i + i + i;
            }
        }
        return "";
    }
}