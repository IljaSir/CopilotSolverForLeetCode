class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> result = new ArrayList<>();
        generateParenthesis(result, "", n, n);
        return result;
    }
    
    public void generateParenthesis(List<String> result, String str, int open, int close) {
        if (open == 0 && close == 0) {
            result.add(str);
            return;
        }
        if (open > 0) {
            generateParenthesis(result, str + "(", open - 1, close);
        }
        if (close > open) {
            generateParenthesis(result, str + ")", open, close - 1);
        }
    }
}