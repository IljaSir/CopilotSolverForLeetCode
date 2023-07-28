class Solution {
    public int numSplits(String s) {
        
        int[] left = new int[26], right = new int[26];
        int leftUnique = 0, rightUnique = 0;
        for (char c : s.toCharArray()) {
            if (right[c - 'a'] == 0) {
                rightUnique++;
            }
            right[c - 'a']++;
        }
        int ans = 0;
        for (char c : s.toCharArray()) {
            left[c - 'a']++;
            right[c - 'a']--;
            if (left[c - 'a'] == 1) {
                leftUnique++;
            }
            if (right[c - 'a'] == 0) {
                rightUnique--;
            }
            if (leftUnique == rightUnique) {
                ans++;
            }
        }
        return ans;
    }
}