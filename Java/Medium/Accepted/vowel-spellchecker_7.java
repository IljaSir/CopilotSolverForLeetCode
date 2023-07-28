class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        
        String[] result = new String[queries.length];
        Set<String> words = new HashSet<>();
        Map<String, String> cap = new HashMap<>();
        Map<String, String> vowel = new HashMap<>();
        for (String word : wordlist) {
            words.add(word);
            String lower = word.toLowerCase();
            String devowel = lower.replaceAll("[aeiou]", "#");
            cap.putIfAbsent(lower, word);
            vowel.putIfAbsent(devowel, word);
        }
        for (int i = 0; i < queries.length; i++) {
            if (words.contains(queries[i])) {
                result[i] = queries[i];
            } else {
                String lower = queries[i].toLowerCase();
                if (cap.containsKey(lower)) {
                    result[i] = cap.get(lower);
                } else {
                    String devowel = lower.replaceAll("[aeiou]", "#");
                    if (vowel.containsKey(devowel)) {
                        result[i] = vowel.get(devowel);
                    } else {
                        result[i] = "";
                    }
                }
            }
        }
        return result;
    }
}