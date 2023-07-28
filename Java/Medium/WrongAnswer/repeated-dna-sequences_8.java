class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 10) {
            return result;
        }
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String sub = s.substring(i, i + 10);
            if (seen.contains(sub)) {
                result.add(sub);
            }
            seen.add(sub);
        }
        return result;
    }
}