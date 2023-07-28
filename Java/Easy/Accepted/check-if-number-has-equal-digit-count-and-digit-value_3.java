class Solution {
    public boolean digitCount(String num) {
        
        int[] digitCount = new int[10];
        for (int i = 0; i < num.length(); i++) {
            digitCount[num.charAt(i) - '0']++;
        }
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) - '0' != digitCount[i]) {
                return false;
            }
        }
        return true;
    }
}