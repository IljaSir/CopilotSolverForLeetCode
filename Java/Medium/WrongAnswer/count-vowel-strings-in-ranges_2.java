class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        
        int[] ans = new int[queries.length];
        int[] a = new int[words.length];
        int[] e = new int[words.length];
        int[] i = new int[words.length];
        int[] o = new int[words.length];
        int[] u = new int[words.length];
        for (int j = 0; j < words.length; j++) {
            for (int k = 0; k < words[j].length(); k++) {
                char c = words[j].charAt(k);
                if (c == 'a') {
                    a[j]++;
                } else if (c == 'e') {
                    e[j]++;
                } else if (c == 'i') {
                    i[j]++;
                } else if (c == 'o') {
                    o[j]++;
                } else if (c == 'u') {
                    u[j]++;
                }
            }
        }
        for (int j = 0; j < queries.length; j++) {
            int l = queries[j][0];
            int r = queries[j][1];
            int sum = 0;
            for (int k = l; k <= r; k++) {
                sum += a[k] + e[k] + i[k] + o[k] + u[k];
            }
            ans[j] = sum;
        }
        return ans;
    }
}