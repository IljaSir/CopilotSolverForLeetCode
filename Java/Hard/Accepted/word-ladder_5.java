class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> dict = new HashSet<>();
        for (String word : wordList) {
            dict.add(word);
        }
        if (!dict.contains(endWord)) {
            return 0;
        }
        Set<String> start = new HashSet<>();
        start.add(beginWord);
        Set<String> end = new HashSet<>();
        end.add(endWord);
        return bfs(start, end, dict, 2);
    }
    private int bfs(Set<String> start, Set<String> end, Set<String> dict, int level) {
        if (start.size() == 0) {
            return 0;
        }
        if (start.size() > end.size()) {
            return bfs(end, start, dict, level);
        }
        dict.removeAll(start);
        Set<String> next = new HashSet<>();
        for (String word : start) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char temp = chars[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[i] = c;
                    String nextWord = new String(chars);
                    if (dict.contains(nextWord)) {
                        if (end.contains(nextWord)) {
                            return level;
                        }
                        next.add(nextWord);
                    }
                }
                chars[i] = temp;
            }
        }
        return bfs(next, end, dict, level + 1);
    }
}