class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        
        Set<String> words = new HashSet<>();
        Map<String, String> caps = new HashMap<>();
        Map<String, String> vowels = new HashMap<>();
        for (String word : wordlist) {
            words.add(word);
            String lower = word.toLowerCase();
            caps.putIfAbsent(lower, word);
            vowels.putIfAbsent(devowel(lower), word);
        }
        for (int i = 0; i < queries.length; i++) {
            if (words.contains(queries[i])) continue;
            String lower = queries[i].toLowerCase();
            if (caps.containsKey(lower)) {
                queries[i] = caps.get(lower);
                continue;
            }
            String devoweled = devowel(lower);
            if (vowels.containsKey(devoweled)) {
                queries[i] = vowels.get(devoweled);
            } else {
                queries[i] = "";
            }
        }
        return queries;
    }
}