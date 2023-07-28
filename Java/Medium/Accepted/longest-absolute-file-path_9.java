class Solution {
    public int lengthLongestPath(String input) {
        
        int max = 0;
        int cur = 0;
        int level = 0;
        int[] levels = new int[100];
        for (String s : input.split("\n")) {
            level = s.lastIndexOf("\t") + 1;
            cur = levels[level] + s.length() - level + 1;
            levels[level + 1] = cur;
            if (s.contains(".")) {
                max = Math.max(max, cur - 1);
            }
        }
        return max;
    }
}