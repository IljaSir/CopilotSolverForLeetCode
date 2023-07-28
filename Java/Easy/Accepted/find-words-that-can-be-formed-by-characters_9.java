class Solution {
    public int countCharacters(String[] words, String chars) {
        
        int[] charMap = new int[26];
        for (char ch : chars.toCharArray()) {
            charMap[ch - 'a']++;
        }
        int count = 0;
        for (String word : words) {
            int[] tempMap = Arrays.copyOf(charMap, charMap.length);
            boolean isGood = true;
            for (char ch : word.toCharArray()) {
                if (--tempMap[ch - 'a'] < 0) {
                    isGood = false;
                    break;
                }
            }
            if (isGood) {
                count += word.length();
            }
        }
        return count;
    }
}