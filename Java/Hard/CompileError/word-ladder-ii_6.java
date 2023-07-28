class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        List<List<String>> result = new ArrayList<>();
        if (wordList.size() == 0) {
            return result;
        }
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return result;
        }
        Map<String, List<String>> neighbors = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        bfs(beginWord, endWord, wordSet, neighbors, distance);
        dfs(beginWord, endWord, neighbors, distance, result, new ArrayList<>());
        return result;
    }

    private void bfs(String beginWord, String endWord, Set<String> wordSet,
                     Map<String, List<String>> neighbors, Map<String, Integer> distance) {
        for (String word : wordSet) {
            neighbors.put(word, new ArrayList<>());
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);
        while (!queue.isEmpty()) {
            boolean foundEnd = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                int curDistance = distance.get(word);
                List<String> nextWords = getNextWords(word, wordSet);
                for (String nextWord : nextWords) {
                    neighbors.get(word).add(nextWord);
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
        List<String> nextWords = new ArrayList<>();
        char[] charArray = word.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < word.length(); i++) {
                if (charArray[i] == ch) {
                    continue;
                }
                char oldCh = charArray[i];
                charArray[i] = ch;
                if (wordSet.contains(String.valueOf(charArray))) {
                    nextWords.add(String.valueOf(charArray));
                }
                charArray[i] = oldCh;
            }
        }
        return next
    }
}