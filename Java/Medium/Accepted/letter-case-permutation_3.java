class Solution {
    public List<String> letterCasePermutation(String s) {
        
        List<String> result = new ArrayList<>();
        result.add(s);
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                int size = result.size();
                for (int j = 0; j < size; j++) {
                    char[] chars = result.get(j).toCharArray();
                    if (Character.isUpperCase(chars[i])) {
                        chars[i] = Character.toLowerCase(chars[i]);
                    } else {
                        chars[i] = Character.toUpperCase(chars[i]);
                    }
                    result.add(String.valueOf(chars));
                }
            }
        }
        return result;
    }
}