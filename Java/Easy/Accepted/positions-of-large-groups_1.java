class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        
        List<List<Integer>> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                end = i;
            } else {
                if (end - start >= 2) {
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(end);
                    result.add(list);
                }
                start = i;
                end = i;
            }
        }
        if (end - start >= 2) {
            List<Integer> list = new ArrayList<>();
            list.add(start);
            list.add(end);
            result.add(list);
        }
        return result;
    }
}