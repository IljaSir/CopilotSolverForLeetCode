class Solution {
    public int countVowelSubstrings(String word) {
        
        int a = 0, e = 0, i = 0, o = 0, u = 0;
        for (char c : word.toCharArray()) {
            if (c == 'a') {
                a = 1 + a + a + a + a;
            } else if (c == 'e') {
                e = a + e + e + e;
            } else if (c == 'i') {
                i = e + i + i;
            } else if (c == 'o') {
                o = i + o + o;
            } else if (c == 'u') {
                u = o + u + u + u;
            }
        }
        return a + e + i + o + u;
    }
}