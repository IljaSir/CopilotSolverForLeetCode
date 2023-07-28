class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        return wordBreak(s, new HashSet(wordDict), 0, new HashMap());
    }

    private List<String> wordBreak(String s, Set<String> wordDict, int start, Map<Integer, List<String>> memo) {
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> result = new ArrayList();
        if (start == s.length()) {
            result.add("");
        }

        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = wordBreak(s, wordDict, end, memo);
                for (String l : list) {
                    result.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        memo.put(start, result);
        return result;
    }
}