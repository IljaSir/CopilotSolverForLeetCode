class Solution {
    public String[] splitMessage(String message, int limit) {
        
        int len = message.length();
        int part = 1;
        int start = 0;
        int end = 0;
        List<String> result = new ArrayList<>();
        while (end < len) {
            end = Math.min(len, start + limit);
            result.add(message.substring(start, end) + "<" + part + "/" + (len / limit + 1) + ">");
            start = end;
            part++;
        }
        return result.toArray(new String[0]);
    }
}