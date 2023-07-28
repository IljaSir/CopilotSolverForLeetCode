class Solution {
    public int minSteps(String s, String t) {
        
        int[] sArr = new int[26];
        int[] tArr = new int[26];
        for (char c : s.toCharArray()) {
            sArr[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            tArr[c - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (sArr[i] > tArr[i]) {
                count += sArr[i] - tArr[i];
            }
        }
        return count;
    }
}