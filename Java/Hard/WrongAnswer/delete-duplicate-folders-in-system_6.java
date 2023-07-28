class Solution {
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        
        Map<String, List<List<String>>> map = new HashMap<>();
        for (List<String> path : paths) {
            List<String> subPath = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (String folder : path) {
                sb.append(folder).append("/");
                subPath.add(folder);
                map.computeIfAbsent(sb.toString(), k -> new ArrayList<>()).add(subPath);
            }
        }
        Set<String> set = new HashSet<>();
        for (List<List<String>> list : map.values()) {
            if (list.size() == 1) {
                continue;
            }
            int[] count = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                count[i] = list.get(i).size();
            }
            Arrays.sort(count);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).size() == count[0]) {
                    set.add(String.join("/", list.get(i)));
                }
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (List<String> path : paths) {
            if (!set.contains(String.join("/", path))) {
                ans.add(path);
            }
        }
        return ans;
    }
}