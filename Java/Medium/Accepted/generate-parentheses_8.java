class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        helper(result, "", n, n);
        return result;
    }
    public void helper(List<String> result, String cur, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(cur);
            return;
        }
        if (left > 0) {
            helper(result, cur + "(", left - 1, right);
        }
        if (right > left) {
            helper(result, cur + ")", left, right - 1);
        }
    }
}