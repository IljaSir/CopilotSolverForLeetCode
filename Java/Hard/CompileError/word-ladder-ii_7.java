class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return new ArrayList<>();
        }
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        bfs(beginWord, endWord, wordSet, graph, distance);
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfs(beginWord, endWord, graph, distance, path, res);
        return res;
    }
    
    private void bfs(String beginWord, String endWord, Set<String> wordSet, Map<String, List<String>> graph, Map<String, Integer> distance) {
        for (String word : wordSet) {
            graph.put(word, new ArrayList<>());
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);
        boolean foundEnd = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                int curDistance = distance.get(word);
                List<String> nextWords = getNextWords(word, wordSet);
                for (String nextWord : nextWords) {
                    graph.get(word).add(nextWord);
                    if (!distance.containsKey(nextWord)) {
                        distance.put(nextWord, curDistance + 1);
                        if (nextWord.equals(endWord)) {
                            foundEnd = true;
                        } else {
                            queue.offer(nextWord);
                        }
                    }
                }
            }
            if (foundEnd) {
                break;
            }
        }
    }
    
    private List<String> getNextWords(String word, Set<String> wordSet) {
        List<String> res = new ArrayList<>();
        char[] charArray = word.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i] == ch) {
                    continue;
                }
                char oldChar = charArray[i];
                charArray[i] = ch;
                if (wordSet.contains(String.valueOf(charArray))) {
                    res.add(String.valueOf(charArray));
                }
                charArray[i] = oldChar;
            }
        }
        return res;
    }
}