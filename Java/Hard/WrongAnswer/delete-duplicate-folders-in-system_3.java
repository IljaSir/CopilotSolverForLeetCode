class Solution {
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> path : paths) {
            String key = "";
            for (int i = 0; i < path.size(); i++) {
                key += "/" + path.get(i);
                map.computeIfAbsent(key, k -> new ArrayList<>()).add(path.get(path.size() - 1));
            }
        }
        Set<String> set = new HashSet<>();
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                set.add(key);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> path : paths) {
            String key = "";
            List<String> list = new ArrayList<>();
            for (int i = 0; i < path.size(); i++) {
                key += "/" + path.get(i);
                if (!set.contains(key)) {
                    list.add(path.get(i));
                }
            }
            if (list.size() > 0) {
                res.add(list);
            }
        }
        return res;
    }
}