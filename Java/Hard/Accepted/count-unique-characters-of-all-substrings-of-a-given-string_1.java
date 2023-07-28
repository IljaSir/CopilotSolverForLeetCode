class Solution {
    public int uniqueLetterString(String s) {
        
        int ans = 0;
        int n = s.length();
        int[][] pos = new int[26][2];
        for (int i = 0; i < 26; ++i)
            Arrays.fill(pos[i], -1);
        for (int i = 0; i < n; ++i) {
            int x = s.charAt(i) - 'A';
            ans += (i - pos[x][1]) * (pos[x][1] - pos[x][0]);
            pos[x] = new int[]{pos[x][1], i};
        }
        for (int i = 0; i < 26; ++i)
            ans += (n - pos[i][1]) * (pos[i][1] - pos[i][0]);
        return ans;
    }
}