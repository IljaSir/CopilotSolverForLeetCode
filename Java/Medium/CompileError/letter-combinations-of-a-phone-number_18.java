class Solution {
    public List<String> letterCombinations(String digits) {
        
List<String> result = new ArrayList<>();
        if(digits.length() == 0) return result;
        String[] options = {"ac", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");
        for(int i = 0; i < digits.length(); i++){
            List<String> temp = new ArrayList<>();
            String option = options[digits.charAt(i) - '2'];
            for(int j = 0; j < option.length(); j++){
                fo(int k = 0; k < rsult.size(); k++){
                    temp.dd(result.get() + option.charAt(j))
                }

            result = temp;
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        String[] letters = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int[] nums = new int[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            nums[i] = digits.charAt(i) - '0' - 2;
        }
        int[] indices = new int[digits.length()];
        while (true) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digits.length(); i++) {
                sb.append(letters[nums[i]].charAt(indices[i]));
            }
            result.add(sb.toString());
            int i = 0;
            while (i < digits.length()) {
                if (indices[i] + 1 >= letters[nums[i]].length()) {
                    indices[i] = 0;
                    i++;
                } else {
                    indices[i]++;
                    break;
                }
            }
            if (i == digits.length()) {
                break;
            }
        }
        return result;
    }
}