class Solution {
    public int countVowelSubstrings(String word) {
        
        int vowel[] = new int[5];
        int n = word.length();
        int ans = 0;
        for(int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if(c == 'a') {
                vowel[0]++;
            } else if(c == 'e') {
                vowel[1] += vowel[0];
            } else if(c == 'i') {
                vowel[2] += vowel[1];
            } else if(c == 'o') {
                vowel[3] += vowel[2];
            } else if(c == 'u') {
                vowel[4] += vowel[3];
            }
        }
        for(int i = 0; i < 5; i++) {
            ans += vowel[i];
        }
        return ans;
    }
}