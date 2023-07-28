class Solution {
    public List<String> letterCasePermutation(String s) {
        
        List<String> list = new ArrayList<>();
        if(s == null || s.length() == 0) return list;
        helper(s.toCharArray(), 0, list);
        return list;
    }
    private void helper(char[] ch, int index, List<String> list) {
        if(index == ch.length) {
            list.add(new String(ch));
            return;
        }
        if(Character.isDigit(ch[index])) {
            helper(ch, index + 1, list);
        } else {
            ch[index] = Character.toLowerCase(ch[index]);
            helper(ch, index + 1, list);
            ch[index] = Character.toUpperCase(ch[index]);
            helper(ch, index + 1, list);
        }
    }
}