class Solution {
    public String[] findWords(String[] words) {
        
        String[] keyboard = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (word.length() == 0) {
                continue;
            }
            String wordLower = word.toLowerCase();
            char firstChar = wordLower.charAt(0);
            int index = -1;
            for (int i = 0; i < keyboard.length; i++) {
                if (keyboard[i].indexOf(firstChar) >= 0) {
                    index = i;
                    break;
                }
            }
            boolean valid = true;
            for (int i = 1; i < wordLower.length(); i++) {
                if (keyboard[index].indexOf(wordLower.charAt(i)) < 0) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                result.add(word);
            }
        }
        return result.toArray(new String[result.size()]);
    }
}