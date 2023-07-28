class Solution {
    public String[] splitMessage(String message, int limit) {
        
        int n = message.length();
        int parts = (n + limit - 1) / limit;
        if (parts > limit) {
            return new String[0];
        }
        String[] res = new String[parts];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n) {
            j = i;
            while (j < n && j - i < limit) {
                j++;
            }
            res[k++] = message.substring(i, j) + "<" + k + "/" + parts + ">";
            i = j;
        }
        return res;
    }
}