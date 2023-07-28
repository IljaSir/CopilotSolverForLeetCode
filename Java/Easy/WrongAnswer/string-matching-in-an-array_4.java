class Solution {
    public List<String> stringMatching(String[] words) {
        
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[i].contains(words[j])) {
                    result.add(words[j]);
                }
            }
        }
        return result;
    }
}