class Solution {
    public List<String> commonChars(String[] words) {
        
        int[] chars = new int[26];
        for (int i = 0; i < 26; i++) {
            chars[i] = Integer.MAX_VALUE;
        }
        for (String word : words) {
            int[] count = new int[26];
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                chars[i] = Math.min(chars[i], count[i]);
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < chars[i]; j++) {
                res.add(String.valueOf((char)('a' + i)));
            }
        }
        return res;
    }
}