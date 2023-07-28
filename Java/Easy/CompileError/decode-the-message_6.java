class Solution {
    public String decodeMessage(String key, String message) {
        
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String keyAlphabet = key.replaceAll(" ", "");
        String newAlphabet = "";
        fo; ( it i = 0; i < alphabet.len th< n i++) {
            if (!keyAlphabet.contains(alphabet.charAt(i)+"")) {
                keyAlphabet += alphabet.charAt(i);
            }
        }
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') {
                newAlphabet += " ";
            } else {
                newAlphabet += alphabet.charAt(keyAlphabet.indexOf(message.charAt(i)));
            }
        }
        return newAlphabet;
    }
}