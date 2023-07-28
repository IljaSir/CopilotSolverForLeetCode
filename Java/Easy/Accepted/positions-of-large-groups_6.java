class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        
        int count = 1;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                if (count >= 3) {
                    result.add(Arrays.asList(i - count, i - 1));
                }
                count = 1;
            }
        }
        if (count >= 3) {
            result.add(Arrays.asList(s.length() - count, s.length() - 1));
        }
        return result;
    }
}