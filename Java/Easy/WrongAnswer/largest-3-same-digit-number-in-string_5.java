class Solution {
    public String largestGoodInteger(String num) {
        
        int[] cnt = new int[10];
        for (char c : num.toCharArray()) {
            cnt[c - '0']++;
        }
        for (int i = 9; i >= 0; i--) {
            if (cnt[i] >= 3) {
                return "" + i + i + i;
            }
        }
        return "";
    }
}