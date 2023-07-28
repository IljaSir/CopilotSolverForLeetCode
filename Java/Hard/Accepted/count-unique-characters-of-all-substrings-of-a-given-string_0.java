class Solution {
    public int uniqueLetterString(String s) {
        
        int n = s.length();
        int[][] index = new int[26][2];
        for (int i = 0; i < 26; ++i) {
            Arrays.fill(index[i], -1);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int x = s.charAt(i) - 'A';
            ans += (i - index[x][1]) * (index[x][1] - index[x][0]);
            index[x] = new int[]{index[x][1], i};
        }
        for (int i = 0; i < 26; ++i) {
            ans += (n - index[i][1]) * (index[i][1] - index[i][0]);
        }
        return ans;
    }
}