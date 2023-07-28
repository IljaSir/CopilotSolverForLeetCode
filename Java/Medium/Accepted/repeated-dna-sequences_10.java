class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        List<String> res = new ArrayList<>();
        int n = s.length();
        if(n < 10) return res;
        Map<String, Integer> count = new HashMap<>();
        for(int i=0; i<n-9; i++){
            String tmp = s.substring(i, i+10);
            count.put(tmp, count.getOrDefault(tmp, 0)+1);
        }
        for(String key: count.keySet()){
            if(count.get(key) > 1){
                res.add(key);
            }
        }
        return res;
    }
}