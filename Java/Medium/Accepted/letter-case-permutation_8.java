class Solution {
    public List<String> letterCasePermutation(String s) {
        
        List<String> result = new ArrayList<>();
        char[] cs = s.toCharArray();
        backtrack(cs, 0, result);
        return result;
    }
    
    private void backtrack(char[] cs, int index, List<String> result) {
        if (index == cs.length) {
            result.add(new String(cs));
            return;
        }
        if (Character.isDigit(cs[index])) {
            backtrack(cs, index + 1, result);
        } else {
            cs[index] = Character.toLowerCase(cs[index]);
            backtrack(cs, index + 1, result);
            cs[index] = Character.toUpperCase(cs[index]);
            backtrack(cs, index + 1, result);
        }
    }
}