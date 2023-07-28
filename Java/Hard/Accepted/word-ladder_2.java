class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                char[] wordArray = word.toCharArray();
                for (int j = 0; j < wordArray.length; j++) {
                    char origin = wordArray[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == origin) {
                            continue;
                        }
                        wordArray[j] = k;
                        String nextWord = String.valueOf(wordArray);
                        if (wordSet.contains(nextWord)) {
                            if (nextWord.equals(endWord)) {
                                return step + 1;
                            }
                            queue.offer(nextWord);
                            wordSet.remove(nextWord);
                        }
                    }
                    wordArray[j] = origin;
                }
            }
            step++;
        }
        return 0;
    }
}