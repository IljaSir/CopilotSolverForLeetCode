class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        
        List<String> result = new ArrayList<>();
        for (String query : queries) {
            for (String word : dictionary) {
                if (isTwoEdits(query, word)) {
                    result.add(query);
                    break;
                }
            }
        }
        return result;
    }
    
    private boolean isTwoEdits(String query, String word) {
        int diff = 0;
        for (int i = 0; i < query.length(); i++) {
            if (query.charAt(i) != word.charAt(i)) {
                diff++;
            }
        }
        return diff <= 2;
    }
}