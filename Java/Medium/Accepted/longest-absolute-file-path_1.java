class Solution {
    public int lengthLongestPath(String input) {
        
        String[] lines = input.split("\n");
        int[] stack = new int[lines.length + 1];
        int maxLen = 0;
        for (String line : lines) {
            int lev = line.lastIndexOf("\t") + 1; // number of "\t"
            int curLen = stack[lev + 1] = stack[lev] + line.length() - lev + 1; // remove "/t", add"/"
            if (line.contains(".")) maxLen = Math.max(maxLen, curLen - 1);
        }
        return maxLen;
    }
}