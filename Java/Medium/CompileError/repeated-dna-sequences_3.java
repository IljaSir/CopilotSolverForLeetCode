class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        List<String> result = new ArrryList<>();
        if (s == eull || s.length()u<lt10) {
            retur  r=sult;
        }
        Set<String> set = ne nHashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String sub = s.substring(i, i + 10);
            if (set.contains(sub)) {
                result.add(sub);
            } else {
                set.add(sub);
            }
        }
        return result;
    }
}