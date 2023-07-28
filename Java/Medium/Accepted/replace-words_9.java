class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            String root = "";
            for (String s : dictionary) {
                if (word.startsWith(s)) {
                    if (root.length() == 0 || s.length() < root.length()) {
                        root = s;
                    }
                }
            }
            if (root.length() > 0) {
                sb.append(root);
            } else {
                sb.append(word);
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}