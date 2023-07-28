class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        
        Set<String> words = new HashSet<>();
        Map<String, String> cap = new HashMap<>();
        Map<String, String> vowel = new HashMap<>();
        for (String w : wordlist) {
            words.add(w);
            String lower = w.toLowerCase();
            cap.putIfAbsent(lower, w);
            vowel.putIfAbsent(devowel(lower), w);
        }
        for (int i = 0; i < queries.length; i++) {
            if (words.contains(queries[i])) continue;
            String lower = queries[i].toLowerCase();
            if (cap.containsKey(lower)) {
                queries[i] = cap.get(lower);
                continue;
            }
            String dv = devowel(lower);
            if (vowel.containsKey(dv)) {
                queries[i] = vowel.get(dv);
            } else {
                queries[i] = "";
            }
        }
        return queries;
    }
}