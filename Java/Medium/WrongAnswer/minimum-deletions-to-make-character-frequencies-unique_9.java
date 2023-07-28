class Solution {
    public int minDeletions(String s) {
        
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        Arrays.sort(charCount);
        int ans = 0;
        int prev = 0;
        for (int i = 25; i >= 0; i--) {
            if (charCount[i] == 0) {
                break;
            }
            if (charCount[i] > prev) {
                prev = charCount[i];
            } else {
                ans += Math.max(0, prev - charCount[i] + 1);
                prev = Math.max(0, charCount[i] - 1);
            }
        }
        return ans;
    }
}