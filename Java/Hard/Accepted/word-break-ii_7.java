class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        if (s == null || s.length() == 0) {
            return new ArrayList<String>();
        }
        return wordBreakHelper(s, wordDict, new HashMap<String, List<String>>());
    }
    
    private List<String> wordBreakHelper(String s, List<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> result = new ArrayList<String>();
        if (s.length() == 0) {
            result.add("");
            return result;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> subList = wordBreakHelper(s.substring(word.length()), wordDict, map);
                for (String sub : subList) {
                    result.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        map.put(s, result);
        return result;
    }
}