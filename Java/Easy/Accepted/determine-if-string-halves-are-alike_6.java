class Solution {
    public boolean halvesAreAlike(String s) {
        
        int n = s.length();
        String a = s.substring(0, n/2);
        String b = s.substring(n/2);
        int countA = 0;
        int countB = 0;
        for (int i = 0; i < n/2; i++) {
            if (a.charAt(i) == 'a' || a.charAt(i) == 'e' || a.charAt(i) == 'i' || a.charAt(i) == 'o' || a.charAt(i) == 'u' || a.charAt(i) == 'A' || a.charAt(i) == 'E' || a.charAt(i) == 'I' || a.charAt(i) == 'O' || a.charAt(i) == 'U') {
                countA++;
            }
            if (b.charAt(i) == 'a' || b.charAt(i) == 'e' || b.charAt(i) == 'i' || b.charAt(i) == 'o' || b.charAt(i) == 'u' || b.charAt(i) == 'A' || b.charAt(i) == 'E' || b.charAt(i) == 'I' || b.charAt(i) == 'O' || b.charAt(i) == 'U') {
                countB++;
            }
        }
        return countA == countB;
    }
}