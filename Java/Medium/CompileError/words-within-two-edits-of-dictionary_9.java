class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        
        List<String> result = new ArrayList<>();
        Set<String> dict = new HashSet<>();
        for(String s: dictionary) {
            dict.add(s);
        }
        
        for(String s: queries) {
            if(dict.contains(s)) {
                result.add(s);
            } else {
                for(int i=0; i<s.length(); i++) {
                    for(char c='a'; c<='z'; c++) {
                        String newS = s.substring(0, i) + c + s.substring(i+1, s.length());
                        if(dict.contains(newS)) {
                            result.add(s);
                            break;
                        }
                    }eak;
                    }
                } else if (word.length() == dictWord.length() + 1) {
                    if (oneInsert(word, dictWord)) {
                        result.add(word);
                        break;
                    }
                } else if (word.length() == dictWord.length() - 1) {
                    if (oneInsert(dictWord, word)) {
                        result.add(word);
                        break;
                   ;
            }
        }
        return diff == 1;
    }
}