class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        String[] mapping = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            int index = digits.charAt(i) - '2';
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < result.size(); j++) {
                for (int k = 0; k < mapping[index].length(); k++) {
                    temp.add(result.get(j) + mapping[index].charAt(k));
                }
            };
                    break
                }
            }
            if (i == digits.length()) {
        result = temp;
            }
        }
        return result;
    }
}