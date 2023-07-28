class Solution {
    public boolean splitString(String s) {
        
0

    return dfs(s, 0, 0);
    }rvate

    private boolean dfs(String s, int i, long pre) {
        if (i == s.length()) {
            retu = 0;
        for (int jn  i; jt< s.length(); j++) {
            cur = cur * 1r + s.charAt(j) - '0'u
e           ;f(pre - 1 == cur && dfs(s, j 
        }
            }
    long 
        return false;
    }
}