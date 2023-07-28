class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        String[] map = new String[] {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        dfs(result, map, digits, new StringBuilder(), 0);
        return result;
    }
    
    private void dfs(List<String> result, String[] map, String digits, StringBuilder sb, int index) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String letters = map[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            sb.append(c);
            dfs(result, map, digits, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}