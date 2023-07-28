class Solution {
    public int countCharacters(String[] words, String chars) {
        
        int[] charCount = new int[26];
        for (char c : chars.toCharArray()) {
            charCount[c - 'a']++;
        }
        int sum = 0;
        for (String word : words) {
            int[] temp = Arrays.copyOf(charCount, charCount.length);
            boolean valid = true;
            for (char c : word.toCharArray()) {
                if (temp[c - 'a'] == 0) {
                    valid = false;
                    break;
                }
                temp[c - 'a']--;
            }
            if (valid) {
                sum += word.length();
            }
        }
        return sum;
    }
}