class Solution {
    public int minSteps(String s, String t) {
        
        int[] countS = new int[26];
        int[] countT = new int[26];
        for (int i = 0; i < s.length(); i++) {
            countS[s.charAt(i) - 'a']++;
            countT[t.charAt(i) - 'a']++;
        }
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            diff += Math.abs(countS[i] - countT[i]);
        }
        return diff / 2;
    }
}