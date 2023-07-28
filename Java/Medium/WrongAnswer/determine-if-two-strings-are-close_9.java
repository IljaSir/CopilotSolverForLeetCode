class Solution {
    public boolean closeStrings(String word1, String word2) {
        
        if(word1.length() != word2.length()) return false;
        int[] a = new int[26];
        int[] b = new int[26];
        for(int i = 0; i < word1.length(); i++) {
            a[word1.charAt(i) - 'a']++;
            b[word2.charAt(i) - 'a']++;
        }
        int[] c = new int[26];
        int[] d = new int[26];
        for(int i = 0; i < 26; i++) {
            if(a[i] != 0 || b[i] != 0) {
                c[a[i]]++;
                d[b[i]]++;
            }
        }
        for(int i = 0; i < 26; i++) {
            if((c[i] == 0 && d[i] != 0) || (c[i] != 0 && d[i] == 0)) return false;
        }
        return true;
    }
}