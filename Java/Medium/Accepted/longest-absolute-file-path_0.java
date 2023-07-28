class Solution {
    public int lengthLongestPath(String input) {
        
        String[] lines = input.split("\n");
        int[] stack = new int[lines.length + 1];
        int maxLen = 0;
        for (String s : lines) {
            int lev = s.lastIndexOf("\t") + 1; // number of "\t"
            int curLen = stack[lev + 1] = stack[lev] + s.length() - lev + 1; // remove "/t", add"/"
            if (s.contains(".")) maxLen = Math.max(maxLen, curLen - 1);
        }
        return maxLen;
    }
}