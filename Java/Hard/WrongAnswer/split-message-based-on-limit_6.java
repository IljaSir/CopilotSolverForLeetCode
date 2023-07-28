class Solution {
    public String[] splitMessage(String message, int limit) {
        
        int n = message.length();
        int c = n / limit;
        int r = n % limit;
        int p = 0;
        String[] res = new String[c + (r == 0 ? 0 : 1)];
        for (int i = 0; i < c; i++) {
            res[i] = message.substring(p, p + limit) + "<" + (i + 1) + "/" + (c + (r == 0 ? 0 : 1)) + ">";
            p += limit;
        }
        if (r != 0) {
            res[c] = message.substring(p) + "<" + (c + 1) + "/" + (c + (r == 0 ? 0 : 1)) + ">";
        }
        return res;
    }
}