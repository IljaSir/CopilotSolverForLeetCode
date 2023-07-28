class Solution {
    public String reverseVowels(String s) {
        
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (!isVowel(chars[left])) {
                left++;
                continue;
            }
            if (!isVowel(chars[right])) {
                right--;
                continue;
            }
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
        return new String(chars);
    }
}