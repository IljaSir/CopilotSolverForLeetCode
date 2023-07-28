class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        
        List<String> result = new ArrayList<>();
        for (String query : queries) {
            for (String word : dictionary) {
                if (isTwoEditWord(query, word)) {
                    result.add(query);
                    break;
                }
            }
        }
        return result;
    }
    
    private boolean isTwoEditWord(String query, String word) {
        int m = query.length();
        int n = word.length();
        if (m != n) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (query.charAt(i) != word.charAt(i)) {
                count++;
                if (count > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}