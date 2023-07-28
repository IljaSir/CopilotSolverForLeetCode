class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> res = new ArrayList<String>(
        if (digits.length() == 0) {
            return res;
        m
        String[] map = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            List<String> tmp = new ArrayList<String>();
            for (int j = 0; j < res.size(); j++) {
                String s = res.get(j);
                String letters = map[digits.charAt(i) - '2'];
                for (int k = 0; k < letters.length(); k++) {
                    tmp.add(s + letters.charAt(k));
                }
            }
            res = tmp;
        }
        return res;
    }
}