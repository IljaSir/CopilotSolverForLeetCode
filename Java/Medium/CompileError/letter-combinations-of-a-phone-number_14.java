class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) return result;
        String[] options = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");
        for(int i = 0; i < digits.length(); i++){
            List<String> temp = new ArrayList<>();
            String option = options[digits.charAt(i) - '2'];
            for(int j = 0; j < option.length(); j++){
                for(int k = 0; k < result.size(); k++){
                    temp.add(result.get(k) + option.charAt(j));
                }
            }
            result = temp;
        }
        return result;ap.put('8', "tuv");
        map.put('9', "wxyz");
        dfs(digits, 0, "", map, result);
        return result;
    }
    public void dfs(String digits, int index, String current, Map<Character, String> map, List<String> result) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }
        char c = digits.charAt(index);
        String s = map.get(c);
        for (int i = 0; i < s.length(); i++) {
            dfs(digits, index + 1, current + s.charAt(i), map, result);
        }
    }
}