class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        
        Map<String, String> cap = new HashMap<>();
        Map<String, String> vowel = new HashMap<>();
        Set<String> words = new HashSet<>();
        for (String w : wordlist) {
            String lower = w.toLowerCase();
            String devowel = lower.replaceAll("[aeiou]", "#");
            cap.putIfAbsent(lower, w);
            vowel.putIfAbsent(devowel, w);
            words.add(w);
        }
        for (int i = 0; i < queries.length; i++) {
            if (words.contains(queries[i])) {
                continue;
            }
            String lower = queries[i].toLowerCase();
            String devowel = lower.replaceAll("[aeiou]", "#");
            if (cap.containsKey(lower)) {
                queries[i] = cap.get(lower);
            } else if (vowel.containsKey(devowel)) {
                queries[i] = vowel.get(devowel);
            } else {
                queries[i] = "";
            }
        }
        return queries;
    }
}