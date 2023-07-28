class Solution {
    public String reverseWords(String s) {
        
        String[] words = s.split(" ");
        String[] reversedWords = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            reversedWords[i] = reverseWord(words[i]);
        }
        return String.join(" ", reversedWords);
    }

    public String reverseWord(String word) {
        char[] chars = word.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
}