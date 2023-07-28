class Solution {
    public List<String> letterCasePermutation(String s) {
        
        List<String> result = new ArrayList<>();
        result.add(s);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                int size = result.size();
                for (int j = 0; j < size; j++) {
                    String str = result.get(j);
                    char[] chars = str.toCharArray();
                    if (Character.isUpperCase(c)) {
                        chars[i] = Character.toLowerCase(c);
                    } else {
                        chars[i] = Character.toUpperCase(c);
                    }
                    result.add(new String(chars));
                }
            }
        }
        return result;
    }
}