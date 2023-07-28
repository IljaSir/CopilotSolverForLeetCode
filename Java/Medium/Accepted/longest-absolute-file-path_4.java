class Solution {
    public int lengthLongestPath(String input) {
        
        int ans = 0;
        int[] stack = new int[input.length() + 1];
        for (String s : input.split("\n")) {
            int lev = s.lastIndexOf("\t") + 1; // number of "\t"
            int curLen = stack[lev + 1] = stack[lev] + s.length() - lev + 1; // remove "/t", add"/"
            if (s.contains(".")) ans = Math.max(ans, curLen - 1); // for a file, don't count the last"/"
        }
        return ans;
    }
}