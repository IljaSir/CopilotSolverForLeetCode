class Solution {
    public int countCharacters(String[] words, String chars) {
        
        int[] charCount = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            charCount[chars.charAt(i) - 'a']++;
        }
        int sum = 0;
        for (String word : words) {
            int[] temp = Arrays.copyOf(charCount, charCount.length);
            boolean isGood = true;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (temp[idx] > 0) {
                    temp[idx]--;
                } else {
                    isGood = false;
                    break;
                }
            }
            if (isGood) {
                sum += word.length();
            }
        }
        return sum;
    }
}