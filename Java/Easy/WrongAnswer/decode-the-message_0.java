class Solution {
    public String decodeMessage(String key, String message) {
        
        char[] keyMap = new char[26];
        for (int i = 0; i < 26; i++) {
            keyMap[i] = ' ';
        }
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (c != ' ') {
                keyMap[c - 'a'] = (char) ('a' + i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c != ' ') {
                sb.append(keyMap[c - 'a']);
            } else {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}