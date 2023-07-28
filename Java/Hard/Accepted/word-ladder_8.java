class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> dict = new HashSet<String>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int step = 0;
        while (!queue.isEmpty()) {
            ++step;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String word = queue.poll();
                for (int j = 0; j < word.length(); ++j) {
                    char[] chars = word.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        chars[j] = ch;
                        String nextWord = new String(chars);
                        if (dict.contains(nextWord)) {
                            if (nextWord.equals(endWord)) {
                                return step + 1;
                            }
                            queue.offer(nextWord);
                            dict.remove(nextWord);
                        }
                    }
                }
            }
        }
        return 0;
    }
}