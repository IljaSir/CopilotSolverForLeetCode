class Solution {
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        
        List<List<String>> result = new ArrayList<>();
        Map<String, List<List<String>>> map = new HashMap<>();
        for (List<String> path: paths) {
            String key = String.join("/", path);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(path);
        }
        for (List<List<String>> list: map.values()) {
            if (list.size() == 1) {
                result.add(list.get(0));
            }
        }
        return result;
    }
}