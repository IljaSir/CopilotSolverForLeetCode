class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] arr = path.split(" ");
            String dir = arr[0];
            for (int i = 1; i < arr.length; i++) {
                String fileName = arr[i].substring(0, arr[i].indexOf("("));
                String fileContent = arr[i].substring(arr[i].indexOf("(") + 1, arr[i].indexOf(")"));
                map.putIfAbsent(fileContent, new ArrayList<>());
                map.get(fileContent).add(dir + "/" + fileName);
            }
        }
        for (List<String> list : map.values()) {
            if (list.size() > 1) ans.add(list);
        }
        return ans;
    }
}