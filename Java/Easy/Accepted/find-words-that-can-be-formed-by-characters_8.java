class Solution {
    public int countCharacters(String[] words, String chars) {
        
        int sum = 0;
        for (String word : words) {
            if (canForm(word, chars)) {
                sum += word.length();
            }
        }
        return sum;
    }
    
    private boolean canForm(String word, String chars) {
        int[] count = new int[26];
        for (char c : chars.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : word.toCharArray()) {
            if (count[c - 'a'] == 0) {
                return false;
            }
            count[c - 'a']--;
        }
        return true;
    }
}