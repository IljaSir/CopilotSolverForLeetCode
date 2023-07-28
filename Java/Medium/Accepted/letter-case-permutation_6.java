class Solution {
    public List<String> letterCasePermutation(String s) {
        
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            result.add(s);
            return result;
        }
        dfs(s, 0, result);
        return result;
    }

    private void dfs(String s, int index, List<String> result) {
        if (index == s.length()) {
            result.add(s);
            return;
        }

        char ch = s.charAt(index);
        if (Character.isDigit(ch)) {
            dfs(s, index + 1, result);
            return;
        }

        char[] chars = s.toCharArray();
        chars[index] = Character.toLowerCase(ch);
        dfs(new String(chars), index + 1, result);

        chars[index] = Character.toUpperCase(ch);
        dfs(new String(chars), index + 1, result);
    }
}