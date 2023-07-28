class Solution {
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        
        HashMap<String, Integer> pathMap = new HashMap<>();
        HashMap<Integer, Integer> parentMap = new HashMap<>();
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (List<String> path : paths) {
            int curr = 0;
            for (String dir : path) {
                String pathStr = dir + " " + curr;
                if (!pathMap.containsKey(pathStr)) {
                    pathMap.put(pathStr, pathMap.size());
                }
                int next = pathMap.get(pathStr);
                parentMap.put(next, curr);
                countMap.put(curr, countMap.getOrDefault(curr, 0) + 1);
                curr = next;
            }
        }
        HashMap<Integer, Integer> rootMap = new HashMap<>();
        for (int node : parentMap.keySet()) {
            int root = findRoot(node, parentMap);
            rootMap.put(root, node);
        }
        List<List<String>> ans = new ArrayList<>();
        for (List<String> path : paths) {
            List<String> newPath = new ArrayList<>();
            int curr = 0;
            for (String dir : path) {
                String pathStr = dir + " " + curr;
                int next = pathMap.get(pathStr);
                if (countMap.get(next) > 1) {
                    newPath = new ArrayList<>();
                } else {
                    newPath.add(dir);
                }
                curr = next;
            }
            if (newPath.size() > 0) {
                ans.add(newPath);
            }
        }
        return ans;
    }
    private int findRoot(int node, HashMap<Integer, Integer> parentMap) {
        while (parentMap.containsKey(node)) {
            node = parentMap.get(node);
        }
        return node;
    }
}