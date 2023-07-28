class Solution {
    public String decodeMessage(String key, String message) {
        
        char[] keyArr = key.toCharArray();
        char[] messageArr = message.toCharArray();
        String[] alphabets = new String[26];
        int keyPos = 0;
        for (int i = 0; i < messageArr.length; i++) {
            if (messageArr[i] == ' ') {
                continue;
            }
            char ch = messageArr[i];
            if (alphabets[ch - 'a'] == null) {
                while (keyArr[keyPos] == ' ') {
                    keyPos++;
                }
                alphabets[ch - 'a'] = String.valueOf(keyArr[keyPos]);
                keyPos++;
            }
            messageArr[i] = alphabets[ch - 'a'].charAt(0);
        }
        return new String(messageArr);
    }
}