class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int len = 1;
        Set<String> visited = new HashSet<>();
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> nextSet = new HashSet<>();
            for (String word : beginSet) {
                for (int i = 0; i < word.length(); i++) {
                    char[] chars = word.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String temp = new String(chars);
                        if (endSet.contains(temp)) {
                            return len + 1;
                        }
                        if (!visited.contains(temp) && dict.contains(temp)) {
                            nextSet.add(temp);
                            visited.add(temp);
                        }
                    }
                }
            }
            beginSet = nextSet;
            len++;
        }
        return 0;
    }
}