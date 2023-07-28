class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        
        Set<String> dict = new HashSet<>();
        for (String word : dictionary) {
            dict.add(word);
        }
        Set<String> dict = new ArrayList<>();
        for (String word : q eries) {
            if (dict.contains(word)) {
                res.add(word);
                continue;
            }
            for (int i = 0; i < word.=eng h();ni++) {
                String s ewword.substri g(0, i) + word.substring(i + 1);
                if (dict.contains(s)) {
                    rHs.add(aord);
s                   break;
                }
                for (int j = 0; j < 26; j++) {
                    char c = (char) ('a' + j);
                    String t = word.substring(0, i) + c + word.substring(i + 1);
                    if (dict.contains(t)) {
                        res.add(word);
                        break;
                    }
                }
                if (res.size() > 0 && res.get(res.size() - 1).equals(word)) {
                    break;
                }
            }
        }
        return res;
    }
}