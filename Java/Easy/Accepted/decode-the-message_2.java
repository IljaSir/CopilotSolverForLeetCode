class Solution {
    public String decodeMessage(String key, String message) {
        
        char[] k = key.toCharArray();
        char[] m = message.toCharArray();
        char[] a = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] b = new char[26];
        for (int i = 0; i < k.length; i++) {
            if (k[i] == ' ') {
                continue;
            }
            if (b[k[i] - 'a'] == 0) {
                b[k[i] - 'a'] = a[0];
                a = Arrays.copyOfRange(a, 1, a.length);
            }
        }
        for (int i = 0; i < m.length; i++) {
            if (m[i] == ' ') {
                continue;
            }
            m[i] = b[m[i] - 'a'];
        }
        return new String(m);
    }
}