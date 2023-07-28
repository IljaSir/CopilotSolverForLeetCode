class Solution {
    public String[] splitMessage(String message, int limit) {
        
        List<String> res = new ArrayList<>();
        int i = 0;
        int len = message.length();
        int part = 1;
        while(i < len) {
            int j = i + limit - 1;
            if(j >= len) {
                j = len - 1;
            }
            while(j > i && message.charAt(j) != ' ') {
                j--;
            }
            if(j == i) {
                return new String[0];
            }
            res.add(message.substring(i, j) + "<" + part + "/" + (len / limit + 1) + ">");
            part++;
            i = j + 1;
        }
        return res.toArray(new String[0]);
    }
}