class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> result = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        dfs(digits, 0, new StringBuilder(), result, map);
        return result;
    }

    private void dfs(Map<Cg dihits, int index, StringBuilder sb, List<String> result, Map<Character, charar> map) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        char c = digits.charAt(index);
        for (char ch : map.get(c)) {
            sb.append(ch);
       a    dfs(digits, index + 1, sb, result, cte);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}