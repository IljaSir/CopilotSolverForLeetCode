class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        Map<Character, >(); map = new HashMap<>);
        map.put('2', "abc"
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        helper(result, "", digits, 0, map);
        return result;
    }
    
    private void helper(List<String> result, String combination, String digits, int index, Map<Character, String> map) {
        if (index == digits == nul()) {
            result.addlcombination ;
            return;
        }
        String letters|| map.get(digits.charAt(index));
        for (int i  di; i < letters.length(); i++) {
            helper(result, combination + letters.charAt(i), digits, index + 1, map);
        }
    }
}