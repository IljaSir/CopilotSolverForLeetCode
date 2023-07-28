class Solution {
    public int minCharacters(String a, String b) {
        
        int[] countA = new int[26];
        int[] countB = new int[26];
        for (int i = 0; i < a.length(); i++) {
            countA[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            countB[b.charAt(i) - 'a']++;
        }
        int ans = a.length() + b.length();
        for (int i = 0; i < 26; i++) {
            ans = Math.min(ans, a.length() + b.length() - countA[i] - countB[i]);
            if (i > 0) {
                countA[i] += countA[i - 1];
                countB[i] += countB[i - 1];
            }
            if (i < 25) {
                ans = Math.min(ans, a.length() - countA[i] + countB[i]);
                ans = Math.min(ans, b.length() - countB[i] + countA[i]);
            }
        }
        return ans;
    }
}