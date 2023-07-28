class Solution {
    public List<String> letterCasePermutation(String s) {
        
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            res.add("");
            return res;
        }
        char[] chars = s.toCharArray();
        dfs(chars, 0, res);
        return res;
    }
    
    private void dfs(char[] chars, int index, List<String> res) {
        if (index == chars.length) {
            res.add(new String(chars));
            return;
        }
        dfs(chars, index + 1, res);
        if (Character.isLetter(chars[index])) {
            chars[index] = Character.isLowerCase(chars[index]) ? Character.toUpperCase(chars[index]) : Character.toLowerCase(chars[index]);
            dfs(chars, index + 1, res);
        }
    }
}