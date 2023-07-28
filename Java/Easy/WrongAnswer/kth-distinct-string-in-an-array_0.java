class Solution {
    public String kthDistinct(String[] arr, int k) {
        
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<String> list = new ArrayList<>();
        for (String s : map.keySet()) {
            if (map.get(s) == 1) {
                list.add(s);
            }
        }
        return list.size() >= k ? list.get(k - 1) : "";
    }
}