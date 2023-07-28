class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] split = path.split(" ");
            String dir = split[0];
            for (int i = 1; i < split.length; i++) {
                int start = split[i].indexOf("(");
                String filename = split[i].substring(0, start);
                String content = split[i].substring(start + 1, split[i].length() - 1);
                map.putIfAbsent(content, new ArrayList<>());
                map.get(content).add(dir + "/" + filename);
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