class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < wordlist.length; i++) {
            String word = wordlist[i];
            map.putIfAbsent(word.toLowerCase(), i);
            map.putIfAbsent(word.replaceAll("[aeiou]", "#").toLowerCase(), i);
        }
        String[] ans = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String word = queries[i];
            if (map.containsKey(word)) {
                ans[i] = wordlist[map.get(word)];
            } else if (map.containsKey(word.toLowerCase())) {
                ans[i] = wordlist[map.get(word.toLowerCase())];
            } else if (map.containsKey(word.replaceAll("[aeiou]", "#").toLowerCase())) {
                ans[i] = wordlist[map.get(word.replaceAll("[aeiou]", "#").toLowerCase())];
            } else {
                ans[i] = "";
            }
        }
        return ans;
    }
}