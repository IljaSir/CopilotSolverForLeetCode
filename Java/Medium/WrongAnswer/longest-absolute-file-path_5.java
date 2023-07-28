class Solution {
    public int lengthLongestPath(String input) {
        
        int max = 0;
        int[] stack = new int[input.length()+1];
        for (String s: input.split("\n")) {
            int level = s.lastIndexOf("\t") + 1;
            int len = s.length() - level + 1;
            if (s.contains(".")) {
                max = Math.max(max, stack[level] + len);
            } else {
                stack[level + 1] = stack[level] + len;
            }
        }
        return max;
    }
}