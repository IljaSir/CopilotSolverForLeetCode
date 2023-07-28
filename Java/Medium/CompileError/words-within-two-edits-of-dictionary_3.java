class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        
        Set<String> dict = new HashSet<>();
        for (String word : dictionary) {
            dict.add(word);
        }
        List<String> result = new ArrayList<>();
        for (String word : queries) {
            if (dict.contains(word)) {
                result.add(word);
                continue;
            }
            for (int i = 0; i < word.length(); i++) {
                Str;
            }
        }
        return diff == 1;
    }
}