class Solution {
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> path : paths) {
            map.computeIfAbsent(path.get(0), k -> new ArrayList<>()).add(String.join("/", path.subList(1, path.size())));
        }
        Set<String> set = new HashSet<>();
        dfs(map, set, "");
        List<List<String>> ans = new ArrayList<>();
        for (List<String> path : paths) {
            if (!set.contains(String.join("/", path))) {
                ans.add(path);
            }
        }
        return ans;
    }
    private String dfs(Map<String, List<String>> map, Set<String> set, String path) {
        if (!map.containsKey(path)) {
            return "";
        }
        List<String> sub = map.get(path);
        List<String> list = new ArrayList<>();
        for (String s : sub) {
            list.add(dfs(map, set, path + "/" + s));
        }
        Collections.sort(list);
        String str = String.join("/", list);
        if (str.length() > 0 && set.contains(str)) {
            set.add(path + "/" + str);
        }
        return str;
    }
}