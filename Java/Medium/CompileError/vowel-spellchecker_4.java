class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        
        Set<String> words = new HashSet<>();
        Map<String, String> caps = new HashMap<>();
        Map<String, String> vowels = new HashMap<>();
        for (String w: wordlist) {
            words.add(w);
            String lower = w.toLowerCase();
            caps.putIfAbsent(lower, w);
            vowels.putIfAbsent(devowel(lower), w);
        }
        for (int i = 0; i < queries.length; i++) {
            if (words.contains(queries[i])) continue;
            String lower = queries[i].toLowerCase();
            if (caps.containsKey(lower)) {
                queries[i] = caps.get(lower);
                continue;
            }
            String dv = devowel(lower);
            if (vowels.containsKey(dv)) {
                queries[i] = vowels.get(dv);
            } else {
                queries[i] = "";
            }
        }
        return queries;
    }
}