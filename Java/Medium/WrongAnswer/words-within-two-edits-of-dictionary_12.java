class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        
        List<String> result = new ArrayList<>();
        Set<String> dictionarySet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for (String word : dictionary) {
            dictionarySet.add(word);
        }
        for (String query : queries) {
            if (dictionarySet.contains(query)) {
                result.add(query);
                continue;
            }
            for (int i = 0; i < query.length(); i++) {
                String newWord = query.substring(0, i) + query.substring(i + 1);
                if (dictionarySet.contains(newWord)) {
                    result.add(query);
                    break;
                }
            }
        }
        return result;
    }
}