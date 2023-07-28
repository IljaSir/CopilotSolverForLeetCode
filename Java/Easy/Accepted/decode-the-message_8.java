class Solution {
    public String decodeMessage(String key, String message) {
        
        Map<Character, Character> map = new HashMap<>();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] keyArr = key.toCharArray();
        char[] messageArr = message.toCharArray();
        int index = 0;
        for (char c : keyArr) {
            if (c == ' ') {
                continue;
            }
            if (!map.containsKey(c)) {
                map.put(c, alphabet.charAt(index));
                index++;
            }
        }
        for (char c : alphabet.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, alphabet.charAt(index));
                index++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : messageArr) {
            if (c == ' ') {
                sb.append(c);
            } else {
                sb.append(map.get(c));
            }
        }
        return sb.toString();
    }
}