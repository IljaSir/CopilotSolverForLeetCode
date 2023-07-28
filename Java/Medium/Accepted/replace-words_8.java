class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            String root = "";
            for (String d : dictionary) {
                if (word.startsWith(d)) {
                    if (root == "" || d.length() < root.length()) {
                        root = d;
                    }
                }
            }
            if (root == "") {
                sb.append(word);
            } else {
                sb.append(root);
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}