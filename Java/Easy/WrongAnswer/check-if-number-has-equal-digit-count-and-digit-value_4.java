class Solution {
    public boolean digitCount(String num) {
        
        int[] count = new int[10];
        for (char c : num.toCharArray()) {
            count[c - '0']++;
        }
        for (int i = 0; i < num.length(); i++) {
            int c = num.charAt(i) - '0';
            if (count[c] != c) {
                return false;
            }
        }
        return true;
    }
}