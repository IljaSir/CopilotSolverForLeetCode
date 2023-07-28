class Solution {
    public String[] splitMessage(String message, int limit) {
        
        int n = message.length();
        int parts = (n + limit - 1)/limit;
        String[] result = new String[parts];
        int start = 0;
        for (int i = 0; i < parts; i++) {
            int end = Math.min(start + limit, n);
            result[i] = message.substring(start, end) + "<" + (i + 1) + "/" + parts + ">";
            start = end;
        }
        return result;
    }
}