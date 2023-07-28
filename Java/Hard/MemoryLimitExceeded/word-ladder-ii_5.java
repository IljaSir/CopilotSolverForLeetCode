class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!dict.contains(endWord)) return res;
        Map<String, List<String>> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        boolean found = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> nextVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                char[] wordArr = word.toCharArray();
                for (int j = 0; j < wordArr.length; j++) {
                    char oldChar = wordArr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArr[j] = c;
                        String newWord = String.valueOf(wordArr);
                        if (dict.contains(newWord)) {
                            if (newWord.equals(endWord)) found = true;
                            if (!visited.contains(newWord)) {
                                queue.offer(newWord);
                                nextVisited.add(newWord);
                            }
                            if (map.containsKey(newWord)) {
                                map.get(newWord).add(word);
                            } else {
                                List<String> list = new ArrayList<>();
                                list.add(word);
                                map.put(newWord, list);
                            }
                        }
                    }
                    wordArr[j] = oldChar;
                }
            }
            visited.addAll(nextVisited);
            if (found) break;
        }
        if (!found) return res;
        List<String> path = new ArrayList<>();
        path.add(endWord);
        dfs(res, path, map, beginWord, endWord);
        return res;
    }
    private void dfs(List<List<String>> res, List<String> path, Map<String, List<String>> map, String beginWord, String curWord) {
        if (curWord.equals(beginWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        List<String> prevWords = map.get(curWord);
        for (String prevWord : prevWords) {
            path.add(0, prevWord);
            dfs(res, path, map, beginWord, prevWord);
            path.remove(0);
        }
    }
}