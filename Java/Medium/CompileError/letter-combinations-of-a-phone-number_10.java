class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> results = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return results;
        }
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new charnew'm', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        int n = digits.length();
        char[] chars = digits.toCharArray();
        char[] result = new char[n];
        dfs(chars, 0, result, results, map);
        return results;
    }
    
    private void dfs(char[] chars, int i, char[] result, List<String> results, Map<Character, char[]> map) {
        if (i == chars.length) {
            results.add(new String(result));
            return;
        }
        char[] letters = map.get(chars[i]);
        for (char letter : letters) {
            result[i] = letter;
            dfs(chars, i + 1, result, results, map);
        }
    }
}