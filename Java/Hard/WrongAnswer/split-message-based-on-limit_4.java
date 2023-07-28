class Solution {
    public String[] splitMessage(String message, int limit) {
        
        int n = message.length();
        int num = n / limit;
        if (n % limit != 0) {
            num++;
        }
        String[] res = new String[num];
        int i = 0;
        int j = 0;
        while (i < n) {
            int len = Math.min(limit, n - i);
            res[j] = message.substring(i, i + len) + "<" + (j + 1) + "/" + num + ">";
            i += len;
            j++;
        }
        return res;
    }
}