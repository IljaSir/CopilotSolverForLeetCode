class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String word = queue.poll();
                if (word.equals(endWord)) return step;
                for (int j = 0; j < word.length(); ++j) {
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; ++c) {
                        chars[j] = c;
                        String newWord = String.valueOf(chars);
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
            ++step;
        }
        return 0;
    }
}