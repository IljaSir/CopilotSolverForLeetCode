class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        
        Set<String> words = new HashSet<>();
        Map<String, String> cap = new HashMap<>();
        Map<String, String> vowel = new HashMap<>();
        for (String word : wordlist) {
            words.add(word);
            String lower = word.toLowerCase();
            cap.putIfAbsent(lower, word);
            vowel.putIfAbsent(devowel(lower), word);
        }
        for (int i = 0; i < queries.length; i++) {
            if (words.contains(queries[i])) {
                continue;
            }
            String lower = queries[i].toLowerCase();
            String devoweled = devowel(lower);
            if (cap.containsKey(lower)) {
                queries[i] = cap.get(lower);
            } else if (vowel.containsKey(devoweled)) {
                queries[i] = vowel.get(devoweled);
            } else {
                queries[i] = "";
            }
        }
        return queries;
    }
}