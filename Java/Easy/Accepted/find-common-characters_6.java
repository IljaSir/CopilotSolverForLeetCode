class Solution {
    public List<String> commonChars(String[] words) {
        
        List<String> result = new ArrayList<String>();
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
        for (int i = 0; i < 26; i++) {
            while (count[i]-- > 0) {
                result.add("" + (char)(i + 'a'));
            }
        }
        return result;
    }
}