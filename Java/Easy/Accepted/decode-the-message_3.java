class Solution {
    public String decodeMessage(String key, String message) {
        
        Map<Character, Character> map = new HashMap<>();
        char[] keys = key.toCharArray();
        char[] messages = message.toCharArray();
        int i = 0;
        for (char c : keys) {
            if (c != ' ') {
                if (!map.containsKey(c)) {
                    map.put(c, (char)('a' + i));
                    i++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : messages) {
            if (c == ' ') {
                sb.append(' ');
            } else {
                sb.append(map.get(c));
            }
        }
        return sb.toString();
    }
}