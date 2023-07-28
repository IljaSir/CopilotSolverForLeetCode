class Solution {
    public String[] splitMessage(String message, int limit) {
        
        int len = message.length();
        int part = (len + limit - 1) / limit;
        String[] res = new String[part];
        int i = 0;
        for (int j = 0; j < part; j++) {
            int k = Math.min(limit, len - i);
            String s = message.substring(i, i + k);
            res[j] = s + "<" + (j + 1) + "/" + part + ">";
            i += k;
        }
        return res;
    }
}