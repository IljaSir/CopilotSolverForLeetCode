class Solution {
    public String[] splitMessage(String message, int limit) {
        
        int len = message.length();
        int part = (len + limit - 1) / limit;
        int last = len - limit * (part - 1);
        String[] res = new String[part];
        int i = 0, j = 0;
        while (i < part) {
            res[i] = message.substring(j, j + (i == part - 1 ? last : limit)) + "<" + (i + 1) + "/" + part + ">";
            j += limit;
            i++;
        }
        return res;
    }
}