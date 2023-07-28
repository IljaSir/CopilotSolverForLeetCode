class Solution {
    public String decodeMessage(String key, String message) {
        
        Map<ng alphabet = "abcdefghijklmnopqrstuvwxyz";
        String[] keyArr = key.split("");
        String[] messageArr = message.split("");
        String[] alphabetArr = alphabet.split("");
        String[] newAlphabetArr = new String[26];
        String[] newMessageArr = new String[messageArr.length];
        String newMessage = "";
        int index = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < keyArr.length; j++) {
                if (keyArr[j].equals(alphabetArr[i])) {
                    newAlphabetArr[i] = keyArr[j];
                    keyArr[j] = "";
                    break;
                }
            }
        }
        for (int i = 0; i < messageArr.length; i++) {
            for (int j = 0; j < newAlphabetArr.length; j++) {
                if (messageArr[i].equals(newAlphabetArr[j])) {
                    newMessageArr[i] = alphabetArr[j];
                    break;
                } else if (messageArr[i].equals(" ")) {
                    newMessageArr[i] = " ";
                    break;
                }
            }
        }
        for (int i = 0ring();
    }
}