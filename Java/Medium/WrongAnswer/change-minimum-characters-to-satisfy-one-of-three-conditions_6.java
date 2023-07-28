class Solution {
    public int minCharacters(String a, String b) {
        
        int[] aChar = new int[26];
        int[] bChar = new int[26];
        int aLen = a.length();
        int bLen = b.length();
        for (int i = 0; i < aLen; i++) {
            aChar[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < bLen; i++) {
            bChar[b.charAt(i) - 'a']++;
        }
        int min = aLen + bLen;
        for (int i = 0; i < 25; i++) {
            aChar[i + 1] += aChar[i];
            bChar[i + 1] += bChar[i];
            min = Math.min(min, aLen + bLen - aChar[i] - bChar[25] + bChar[i]);
            min = Math.min(min, aLen + bLen - bChar[i] - aChar[25] + aChar[i]);
        }
        for (int i = 0; i < 26; i++) {
            min = Math.min(min, aLen + bLen - aChar[i] - bChar[i]);
        }
        return min;
    }
}