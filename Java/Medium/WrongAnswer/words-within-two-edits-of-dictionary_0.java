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
                String sub = word.substring(0, i) + word.substring(i + 1);
                if (dict.contains(sub)) {
                    result.add(word);
                    break;
                }
            }
        }
        return result;
    }
}