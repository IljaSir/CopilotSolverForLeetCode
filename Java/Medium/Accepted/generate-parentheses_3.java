class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList();
        backTrack(res, "", 0, 0, n);
        return res;
    }
    
    public void backTrack(List<String> res, String cur, int open, int close, int max) {
        if (cur.length() == 2*max) {
            res.add(cur);
            return;
        }
        if (open < max) {
            backTrack(res, cur+"(", open+1, close, max);
        }
        if (close < open) {
            backTrack(res, cur+")", open, close+1, max);
        }
    }
}