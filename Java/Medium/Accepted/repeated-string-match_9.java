class Solution {
    public int repeatedStringMatch(String a, String b) {
        
        int n = a.length();
        int m = b.length();
        int q = m/n;
        if (m%n!=0) q++;
        String c = "";
        for (int i=0; i<q; i++) {
            c += a;
            if (c.contains(b)) return i+1;
        }
        c += a;
        if (c.contains(b)) return q+1;
        return -1;
    }
}