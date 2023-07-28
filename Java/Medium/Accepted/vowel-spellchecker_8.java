class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        
        String[] result = new String[queries.length];
        HashMap<String, String> words = new HashMap<String, String>();
        HashMap<String, String> caps = new HashMap<String, String>();
        HashMap<String, String> vowels = new HashMap<String, String>();
        for (String word: wordlist) {
            words.put(word, word);
            String lower = word.toLowerCase();
            caps.putIfAbsent(lower, word);
            String vowel = lower.replaceAll("[aeiou]", "#");
            vowels.putIfAbsent(vowel, word);
        }
        for (int i = 0; i < queries.length; i++) {
            if (words.containsKey(queries[i])) {
                result[i] = queries[i];
            } else {
                String lower = queries[i].toLowerCase();
                if (caps.containsKey(lower)) {
                    result[i] = caps.get(lower);
                } else {
                    String vowel = lower.replaceAll("[aeiou]", "#");
                    if (vowels.containsKey(vowel)) {
                        result[i] = vowels.get(vowel);
                    } else {
                        result[i] = "";
                    }
                }
            }
        }
        return result;
    }
}