class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        List<List<String>> ans = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return ans;
        }
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        bfs(beginWord, endWord, wordList, graph, distance);
        dfs(beginWord, endWord, graph, distance, ans, new ArrayList<>());
        return ans;
    }

    private void bfs(String beginWord, String endWord, List<String> wordList, Map<String, List<String>> graph, Map<String, Integer> distance) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);
        for (String word : wordList) {
            graph.put(word, new ArrayList<>());
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                int curDistance = distance.get(word);
                List<String> nextWords = getNextWords(word, wordList);
                for (String nextWord : nextWords) {
                    graph.get(word).add(nextWord);
                    if (!distance.containsKey(nextWord)) {
                        distance.put(nextWord, curDistance + 1);
                        if (endWord.equals(nextWord)) {
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

    private List<String> getNextWords(String word, List<String> wordList) {
        List<String> nextWords = new ArrayList<>();
        char[] charArray = word.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i] == ch) {
                    continue;
                }
                char originChar = charArray[i];
                charArray[i] = ch;
                if (wordList.contains(String.valueOf(charArray))) {
                    nextWords.add(String.valueOf(charArray));
                }
                charArray[i] = originChar;
            }
        }
        return nextWords;
    }
}