class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        
        int[] ans = new int[queries.length];
        int[][] cnt = new int[words.length][5];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (words[i].charAt(j) == 'a') {
                    cnt[i][0]++;
                } else if (words[i].charAt(j) == 'e') {
                    cnt[i][1]++;
                } else if (words[i].charAt(j) == 'i') {
                    cnt[i][2]++;
                } else if (words[i].charAt(j) == 'o') {
                    cnt[i][3]++;
                } else if (words[i].charAt(j) == 'u') {
                    cnt[i][4]++;
                }
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            for (int j = l; j <= r; j++) {
                ans[i] += cnt[j][0] * cnt[j][1] * cnt[j][2] * cnt[j][3] * cnt[j][4];
            }
        }
        return ans;
    }
}