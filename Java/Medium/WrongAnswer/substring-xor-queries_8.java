class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        
        int[] arr = new int[s.length()];
        int[] prefix = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) - '0';
            prefix[i + 1] = prefix[i] ^ arr[i];
        }
        int[][] ans = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            int first = queries[i][0];
            int second = queries[i][1];
            int left = -1, right = -1;
            for (int j = 0; j < s.length(); j++) {
                if (left == -1 && (prefix[j + 1] ^ first) == second) {
                    left = j;
                }
                if (left != -1 && (prefix[s.length()] ^ prefix[left]) == second) {
                    right = s.length() - 1;
                }
                if (left != -1 && right == -1 && (prefix[j + 1] ^ prefix[left]) == second) {
                    right = j;
                }
            }
            ans[i] = new int[]{left, right};
        }
        return ans;
    }
}