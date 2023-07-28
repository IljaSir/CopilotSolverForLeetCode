class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        Set<String> wordDictSet = new HashSet(wordDict);
        Map<String, List<String>> memo = new HashMap();
        return backtrack(s, wordDictSet, memo);
    }
    
    public List<String> backtrack(String s, Set<String> wordDictSet, Map<String, List<String>> memo){
        if(memo.containsKey(s)){
            return memo.get(s);
        }
        List<String> res = new ArrayList();
        if(s.length() == 0){
            res.add("");
            return res;
        }
        for(String word: wordDictSet){
            if(s.startsWith(word)){
                List<String> subList = backtrack(s.substring(word.length()), wordDictSet, memo);
                for(String sub: subList){
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        memo.put(s, res);
        return res;
    }
}