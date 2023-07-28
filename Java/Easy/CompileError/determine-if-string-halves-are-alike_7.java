class Solution {
    public boolean halvesAreAlike(String s) {
        
        int n = s.length();
        int cnt = 0;
        for (int i = 0; i < n / 2; i++) {
            if (isVowel(s.charAt(i))) {
                cnt++;
            }
            if (isVowel(s.charAt(i + n / 2))) {
                cnt--;
            }
        }
        return cnt == 0;
    }
}