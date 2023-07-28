class Solution {
    public List<String> commonChars(String[] words) {
        
        List<String> result = new ArrayList<String>();
        int[] count = new int[26];
        for (int i = 0; i < 26; i++) {
            count[i] = Integer.MAX_VALUE;
        }
        for (String word : words) {
            int[] tempCount = new int[26];
            for (char c : word.toCharArray()) {
                tempCount[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                count[i] = Math.min(count[i], tempCount[i]);
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < count[i]; j++) {
                result.add(String.valueOf((char) (i + 'a')));
            }
        }
        return result;
    }
}