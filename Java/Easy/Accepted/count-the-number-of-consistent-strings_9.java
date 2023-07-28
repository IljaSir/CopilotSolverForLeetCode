class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        
        int[] count = new int[26];
        for (char c: allowed.toCharArray()) {
            count[c - 'a']++;
        }
        int ans = 0;
        for (String w: words) {
            boolean flag = true;
            for (char c: w.toCharArray()) {
                if (count[c - 'a'] == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans++;
            }
        }
        return ans;
    }
}