class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        int len = beginWord.length();
        HashMap<String, List<String>> allComboDict = new HashMap<String, List<String>>();
        wordList.forEach(
            word -> {
                for (int i = 0; i < len; i++) {
                    String newWord = word.substring(0, i) + '*' + word.substring(i + 1, len);
                    List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<String>());
                    transformations.add(word);
                    allComboDict.put(newWord, transformations);
                }
            }
        );
        Queue<Pair<String, Integer>> Q = new LinkedList<Pair<String, Integer>>();
        Q.add(new Pair(beginWord, 0));
        HashMap<String, Integer> visited = new HashMap<String, Integer>();
        visited.put(beginWord, 0);
        boolean found = false;
        HashMap<Integer, List<List<String>>> res = new HashMap<Integer, List<List<String>>>();
        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, len);
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
                    if (adjacentWord.equals(endWord)) {
                        found = true;
                        if (!res.containsKey(level + 1)) {
                            res.put(level + 1, new ArrayList<List<String>>());
                        }
                        List<String> newRes = new ArrayList<String>(node.getKey());
                        newRes.add(endWord);
                        res.get(level + 1).add(newRes);
                    }
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, level + 1);
                        Q.add(new Pair(adjacentWord, level + 1));
                    } else if (visited.get(adjacentWord) == level + 1) {
                        if (!res.containsKey(level + 1)) {
                            res.put(level + 1, new ArrayList<List<String>>());
                        }
                        List<String> newRes = new ArrayList<String>(node.getKey());
                        newRes.add(adjacentWord);
                        res.get(level + 1).add(newRes);
                    }
                }
            }
        }
        return res.getOrDefault(res.size(), new ArrayList<List<String>>());
    }
}