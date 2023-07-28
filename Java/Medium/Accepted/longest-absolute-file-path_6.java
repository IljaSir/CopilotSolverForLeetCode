class Solution {
    public int lengthLongestPath(String input) {
        
        int max = 0;
        int[] stack = new int[input.length()];
        int index = 0;
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 1;
            int len = s.length() - level + (level > 0 ? stack[level - 1] : 0);
            stack[level] = len;
            if (s.contains(".")) {
                max = Math.max(max, len + level);
            }
        }
        return max;
    }
}