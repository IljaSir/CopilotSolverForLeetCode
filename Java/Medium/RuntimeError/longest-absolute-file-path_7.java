class Solution {
    public int lengthLongestPath(String input) {
        
        int max = 0;
        int[] stack = new int[input.length()];
        int level = 0;
        for (String s : input.split("\n")) {
            int i = s.lastIndexOf("\t") + 1;
            level = i + 1;
            int len = s.length() - i;
            if (s.contains(".")) {
                max = Math.max(max, stack[level - 1] + len);
            } else {
                stack[level] = stack[level - 1] + len + 1;
            }
        }
        return max;
    }
}