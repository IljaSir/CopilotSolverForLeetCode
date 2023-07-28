class Solution {
    public boolean halvesAreAlike(String s) {
        
        String vowels = "aeiouAEIOU";
        int count = 0;
        for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {
            if (vowels.indexOf(s.charAt(i)) != -1) count++;
            if (vowels.indexOf(s.charAt(j)) != -1) count--;
        }
        return count == 0;
    }
}