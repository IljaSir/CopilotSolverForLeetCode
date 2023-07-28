class Solution {
    public String findTheString(int[][] lcp) {
        
        int n = lcp.length;
        int[] max = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max[i] = Math.max(max[i], lcp[i][j]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int cur = max[i];
            if (cur == 0) {
                sb.append('a');
            } else {
                char ch = sb.charAt(i - cur);
                if (ch == 'z') {
                    return "";
                } else {
                    sb.append((char) (ch + 1));
                }
            }
        }
        return sb.toString();
    }
}