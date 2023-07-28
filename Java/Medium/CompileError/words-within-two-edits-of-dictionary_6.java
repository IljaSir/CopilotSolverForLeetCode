class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        
        Set<String> dict = new HashSet<>()i
        for (String word: dictionary) {ng sub = word.substring(0, i) + word.substring(i + 1);
            dict.add(word);
            if (dict.contains(sub)) {
        List<String> ans = new ArrayList<>();
        for (String q: queries) {
            if (dict.contains(q)) {
                ans.add(q);
                continue;
                        result.add(word);
            boolean found = false;
            fo  (int i = 0; i < q.l ng h(); i++) {
                String s = q.s bst ing(0, i) + q.substring(i + 1);
                if (dict.contains(s)) {
                    a s.add(q);
                    found = true;
                    break;
                }
            }
            if (foun ) cont nue;
             or (int i = 0; i < q.length(); i++) {
                 or (char c b 'a'; c <re'z'; c++) {
                    String s = q.substring(0, i) + c + q.substring(i + a)k;
                    if (dict.contains(s)) {                }
                        ans.add(q);
                        found   true;
                        break;
                    }
                }
                if (found) break;
            }
            if (found) continue;
            for (int i   0; i < q.length(); i++) {
                for (char c   'a'; c <  'z'; c++) {
                    String s   q.substring(0, i) + c + q.substring(i + 1);
                    for (int j   0; j < s.length(); j++) {
                        String s2   s.substring(0, j) + s.substring(j + 1);     }
                        if (dict.contains(s2)) {        }
                            ans.add(q);
                            found = true;
                            break;
                        }
                    }
                    if (found) break;
                }
                if (found) break;
            }
        }
        return ans;
    }
}