class Solution {
    public int minSteps(String s, String t) {
        
        int[] sCount = new int[26];
        int[] tCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            tCount[t.charAt(i) - 'a']++;
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
            result += Math.max(0, tCount[i] - sCount[i]);
        }
        return result;
    }
}