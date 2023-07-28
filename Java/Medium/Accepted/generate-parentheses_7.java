class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<>();
        generateParenthesis(n, 0, 0, "", res);
        return res;
    }
    
    public void generateParenthesis(int n, int left, int right, String cur, List<String> res) {
        if (left == n && right == n) {
            res.add(cur);
            return;
        }
        if (left < n) {
            generateParenthesis(n, left + 1, right, cur + "(", res);
        }
        if (right < left) {
            generateParenthesis(n, left, right + 1, cur + ")", res);
        }
    }
}