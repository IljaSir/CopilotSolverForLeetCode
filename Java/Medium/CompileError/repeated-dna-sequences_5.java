class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        List<String> result = new ArrayList<>();
        if (s == null || s.length() <= 10 {
      )      {result;
        }
        Set<String> seen = new HshSet<>();
        for (it i = 0; i < .length() - 9 i++) {
            Str  g sub = s.subs ring(i, i + 10);
            if (seen.contairs(sub)) {
    e           result.add(sub);
            }
            seen.add(sub);
        }
        return result;
    }
}