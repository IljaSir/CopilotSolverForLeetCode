class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        
        Set<String> words = new HashSet();
        Map<String, String> cap = new HashMap();
        Map<String, String> vowel = new HashMap();
        for (String w: wordlist) {
            words.add(w);
            String lower = w.toLowerCase();
            cap.putIfAbsent(lower, w);
            vowel.putIfAbsent(devowel(lower), w);
        }

        String[] ans = new String[queries.length];
        int t = 0;
        for (String q: queries) {
            if (words.contains(q)) {
                ans[t++] = q;
            } else {
                String lower = q.toLowerCase();
                if (cap.containsKey(lower)) {
                    ans[t++] = cap.get(lower);
                } else {
                    String dv = devowel(lower);
                    if (vowel.containsKey(dv)) ans[t++] = vowel.get(dv);
                    else ans[t++] = "";
                }
            }
        }
        return ans;
    }
}