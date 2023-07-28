class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        
        List<List<Integer>> result = new ArrayList<>();
        int start = 0;
        while (start < s.length()) {
            int end = start;
            while (end < s.length() && s.charAt(end) == s.charAt(start)) {
                end++;
            }
            if (end - start >= 3) {
                result.add(Arrays.asList(start, end - 1));
            }
            start = end;
        }
        return result;
    }
}