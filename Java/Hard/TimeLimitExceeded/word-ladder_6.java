class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if (!wordList.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) return level;
                for (int j = 0; j < word.length(); j++) {
                    char[] chars = word.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[j] = ch;
                        String newWord = new String(chars);
                        if (wordList.contains(newWord)) {
                            queue.offer(newWord);
                            wordList.remove(newWord);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}