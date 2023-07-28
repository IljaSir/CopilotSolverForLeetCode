class Solution {
    public String destCity(List<List<String>> paths) {
        
        Map<String, String> map = new HashMap<String, String>();
        for(List<String> list: paths){
            map.put(list.get(0), list.get(1));
        }
        String dest = paths.get(0).get(0);
        while(map.get(dest) != null){
            dest = map.get(dest);
        }
        return dest;
    }
}