class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        
        HashSet<String> words = new HashSet<>();
        HashMap<String, String> cap = new HashMap<>();
        HashMap<String, String> vowel = new HashMap<>();
        for (String word : wordlist) {
            words.add(word);
            String lower = word.toLowerCase();
            cap.putIfAbsent(lower, word);
            vowel.putIfAbsent(lower.replaceAll("[aeiou]", "#"), word);
        }
        for (int i = 0; i < queries.length; i++) {
            if (words.contains(queries[i])) {
                continue;
            }
            String lower = queries[i].toLowerCase();
            if (cap.containsKey(lower)) {
                queries[i] = cap.get(lower);
                continue;
            }
            String key = lower.replaceAll("[aeiou]", "#");
            if (vowel.containsKey(key)) {
                queries[i] = vowel.get(key);
                continue;
            }
            queries[i] = "";
        }
        return queries;
    }
}