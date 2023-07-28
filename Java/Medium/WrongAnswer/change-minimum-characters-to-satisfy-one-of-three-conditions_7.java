class Solution {
    public int minCharacters(String a, String b) {
        
        int[] aFreq = new int[26];
        int[] bFreq = new int[26];
        for(char c : a.toCharArray()) {
            aFreq[c-'a']++;
        }
        for(char c : b.toCharArray()) {
            bFreq[c-'a']++;
        }
        int n = a.length();
        int m = b.length();
        int res = n+m;
        for(int i=0; i<25; i++) {
            res = Math.min(res, n+m-aFreq[i]-bFreq[i]);
            res = Math.min(res, n-m+aFreq[i]-bFreq[i]);
            res = Math.min(res, m-n+bFreq[i]-aFreq[i]);
        }
        return res;
    }
}