class Solution {
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        
        Map<String, Integer> map = new HashMap<>();
        for (List<String> path : paths) {
            String cur = "";
            for (String s : path) {
                cur += "/" + s;
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> path : paths) {
            String cur = "";
            boolean flag = true;
            for (String s : path) {
                cur += "/" + s;
                if (map.get(cur) > 1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(path);
            }
        }
        return res;
    }
}