class Solution {
    public String destCity(List<List<String>> paths) {
        
        Map<String, String> map = new HashMap<>();
        for(List<String> path : paths) {
            map.put(path.get(0), path.get(1));
        }
        String dest = paths.get(0).get(0);
        while(map.containsKey(dest)) {
            dest = map.get(dest);
        }
        return dest;
    }
}