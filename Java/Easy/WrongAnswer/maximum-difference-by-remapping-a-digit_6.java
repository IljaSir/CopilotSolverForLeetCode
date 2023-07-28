class Solution {
    public int minMaxDifference(int num) {
        
        int max = num, min = num;
        char[] numStr = String.valueOf(num).toCharArray();
        for (int i = 0; i < numStr.length; i++) {
            char[] maxStr = numStr.clone();
            char[] minStr = numStr.clone();
            for (char j = '0'; j <= '9'; j++) {
                if (numStr[i] == j) {
                    continue;
                }
                maxStr[i] = j;
                minStr[i] = j;
                max = Math.max(max, Integer.parseInt(String.valueOf(maxStr)));
                min = Math.min(min, Integer.parseInt(String.valueOf(minStr)));
            }
        }
        return max - min;
    }
}