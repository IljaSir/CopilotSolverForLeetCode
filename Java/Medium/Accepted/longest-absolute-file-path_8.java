class Solution {
    public int lengthLongestPath(String input) {
        
        int max = 0;
        String[] dirs = input.split("\n");
        int[] dp = new int[dirs.length + 1];
        for (int i = 0; i < dirs.length; i++) {
            String dir = dirs[i];
            int level = dir.lastIndexOf("\t") + 1;
            int len = dir.substring(level).length();
            if (dir.contains(".")) {
                max = Math.max(max, dp[level] + len);
            } else {
                dp[level + 1] = dp[level] + len + 1;
            }
        }
        return max;
    }
}