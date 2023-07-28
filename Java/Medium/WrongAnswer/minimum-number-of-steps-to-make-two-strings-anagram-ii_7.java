class Solution {
    public int minSteps(String s, String t) {
        
        int[] cnts = new int[26];
        for (char c : s.toCharArray()) {
            cnts[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            cnts[c - 'a']--;
        }
        int ans = 0;
        for (int cnt : cnts) {
            ans += Math.abs(cnt);
        }
        return ans / 2;
    }
}