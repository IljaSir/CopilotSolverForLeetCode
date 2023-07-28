class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        HashMap<String, List<String>> graph = new HashMap<>();
        HashMap<String, Integer> distance = new HashMap<>();
        HashSet<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!dict.contains(endWord)) {
            return res;
        }
        bfs(beginWord, endWord, dict, graph, distance);
        dfs(beginWord, endWord, graph, distance, res, new ArrayList<>());
        return res;
    }
    private void bfs(String beginWord, String endWord, HashSet<String> dict, HashMap<String, List<String>> graph, HashMap<String, Integer> distance) {
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        distance.put(beginWord, 0);
        for (String word : dict) {
            graph.put(word, new ArrayList<>());
        }
        while (!q.isEmpty()) {
            String word = q.poll();
            List<String> neighbors = getNeighbors(word, dict);
            for (String neighbor : neighbors) {
                graph.get(word).add(neighbor);
                if (!distance.containsKey(neighbor)) {
                    distance.put(neighbor, distance.get(word) + 1);
                    q.offer(neighbor);
                }
            }
        }
    }
    private List<String> getNeighbors(String word, HashSet<String> dict) {
        List<String> res = new ArrayList<>();
        char[] chs = word.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) {
                    continue;
                }
                char old = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old;
            }
        }
        return res;
    }
}