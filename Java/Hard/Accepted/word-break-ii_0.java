class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        Map<String, List<String>> map = new HashMap<>();
        return dfs(s, wordDict, map);
    }
    
    private List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> res = new ArrayList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> list = dfs(s.substring(word.length()), wordDict, map);
                for (String str : list) {
                    res.add(word + (str.isEmpty() ? "" : " ") + str);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}