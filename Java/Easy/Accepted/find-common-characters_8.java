class Solution {
    public List<String> commonChars(String[] words) {
        
        List<String> result = new ArrayList<>();
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for (String word : words) {
            int[] currentCount = new int[26];
            for (int i = 0; i < word.length(); i++) {
                currentCount[word.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                count[i] = Math.min(count[i], currentCount[i]);
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < count[i]; j++) {
                result.add("" + (char)('a' + i));
            }
        }
        return result;
    }
}