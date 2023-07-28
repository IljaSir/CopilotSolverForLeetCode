class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        
        int n = s.length();
        int m = words.length;
        int ans = 0;
        int[] pos = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pos[i] = i;
        }
        pos[n] = n;
        for (String word : words) {
            int i = 0;
            for (char c : word.toCharArray()) {
                i = pos[i] + 1;
                while (i < n && s.charAt(i) != c) {
                    i++;
                }
            }
            if (i < n) {
                ans++;
            }
        }
        return ans;
    }
}