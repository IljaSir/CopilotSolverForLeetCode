class Solution {
    public int minSteps(String s, String t) {
        
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            cnt[c - 'a']--;
        }
        int ans = 0;
        for (int i : cnt) {
            if (i > 0) {
                ans += i;
            }
        }
        return ans;
    }
}