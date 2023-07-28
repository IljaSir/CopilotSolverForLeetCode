class Solution {
    public int countVowelStrings(int n) {
        
        int[] counts = new int[]{1, 1, 1, 1, 1};
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < counts.length; j++) {
                counts[j] += counts[j - 1];
            }
        }
        return counts[4];
    }
}