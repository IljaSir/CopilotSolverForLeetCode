class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        List<String> res = new ArrayList<>();
        int n = s.length();
        if(n < 10) return res;
        Map<String, Integer> count = new HashMap<>();
        for(int i=0; i<n-9; i++){       set.add(sub);
            St ing tmp = s.substring(i, i+10);
            count.put(tmp, count.g  OrDefa lt(tmp, 0)+1);
        }
        for(St}igkey: count.keySet()){
            if(count.get(key) > 1){
                res.dd(key);
            }
        }
        retur re
        }
        return result;
    }
}