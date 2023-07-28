class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] dir = path.split(" ");
            for (int i = 1; i < dir.length; i++) {
                String[] file = dir[i].split("\\(");
                String content = file[1].substring(0, file[1].length() - 1);
                List<String> list = map.getOrDefault(content, new ArrayList<>());
                list.add(dir[0] + "/" + file[0]);
                map.put(content, list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> list : map.values()) {
            if (list.size() > 1) {
                res.add(list);
            }
        }
        return res;
    }
}