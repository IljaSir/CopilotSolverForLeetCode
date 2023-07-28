class Solution {
    public List<String> commonChars(String[] words) {
        
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for (String word : words) {
            int[] temp = new int[26];
            for (char c : word.toCharArray()) {
                temp[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                count[i] = Math.min(count[i], temp[i]);
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (count[i]-- > 0) {
                result.add(String.valueOf((char) (i + 'a')));
            }
        }
        return result;
    }
}