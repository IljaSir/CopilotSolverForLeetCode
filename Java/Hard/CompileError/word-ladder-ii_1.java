class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!wordSet.contains(endWord)) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        boolean found = false;
        boolean backward = false;
        while (!beginSet.isEmpty() && !endSet.isEmpty() && !found) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
                backward = !backward;
            }
            Set<String> next = new HashSet<>();
            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String newWord = new String(chars);
                        if (endSet.contains(newWord)) {
                            found = true;
                            String key = backward ? newWord : word;
                            String val = backward ? word : newWord;
                            map.putIfAbsent(key, new ArrayList<>());
                            map.get(key).add(val);
                        }
                        if (!found && wordSet.contains(newWord)) {
                            next.add(newWord);
                            String key = backward ? newWord : word;
                            String val = backward ? word : newWord;
                            map.putIfAbsent(key, new ArrayList<>());
                            map.get(key).add(val);
                        }
                    }
                    chars[i] = old;
                }
            }
            beginSet = next;
            wordSet.removeAll(next);
        }
        if (found) {
            List<String> path = new ArrayList<>();
            path.add(beginWord);
            dfs(beginWord, endWord, map, path, res);
        }
        return res;
    }
    private void dfs(String beginWord, String endWord, Map<String, List<String>> map, List<String> path, List<List<String>> res) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (!map.containsKey(beginWord)) {
            return;
    }
}