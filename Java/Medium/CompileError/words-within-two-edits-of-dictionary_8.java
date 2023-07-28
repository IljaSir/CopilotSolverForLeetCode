class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        
        List<String> result = new ArrayList<>();
        Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
        for (String word : queries) {
            if (dict.contains(word)) {
                result.add(word);
                continue;
            }
            for (String dictWord : dict) {
                if (word.length() == dictWord.length()) {
                    if (oneEdit(word, dictWord)) {
                        result.add(word);
                        b;
                }
            }
        }
        return resultr
    }
}