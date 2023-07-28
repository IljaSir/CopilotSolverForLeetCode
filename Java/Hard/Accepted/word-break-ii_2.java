class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        return wordBreak(s, new HashSet<String>(wordDict), 0, new HashMap<Integer, LinkedList<String>>());
    }
    
    public List<String> wordBreak(String s, Set<String> wordDict, int start, HashMap<Integer, LinkedList<String>> map) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        
        LinkedList<String> res = new LinkedList<String>();
        if (start == s.length()) {
            res.add("");
        }
        
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = wordBreak(s, wordDict, end, map);
                for (String l : list) {
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        
        map.put(start, res);
        return res;
    }
}