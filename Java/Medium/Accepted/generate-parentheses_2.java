class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> result = new ArrayList<String>();
        generateParenthesis(result, "", 0, 0, n);
        return result;
    }
    
    private void generateParenthesis(List<String> result, String current, int open, int close, int n) {
        if (current.length() == n * 2) {
            result.add(current);
            return;
        }
        
        if (open < n) {
            generateParenthesis(result, current + "(", open + 1, close, n);
        }
        
        if (close < open) {
            generateParenthesis(result, current + ")", open, close + 1, n);
        }
    }
}