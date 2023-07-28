class Solution {
    public String decodeMessage(String key, String message) {
        
        Map<Character, Character> map = new HashMap<>();
        for (char c : key.toCharArray()) {
            if (c != ' ') {
                map.putIfAbsent(c, ' ');
            }
        }
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int index = 0;
        for (char c : key.toCharArray()) {
            if (c != ' ' && map.get(c) == ' ') {
                map.put(c, alphabet[index++]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c != ' ') {
                sb.append(map.get(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}