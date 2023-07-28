class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (s.length() == 0) {
            return result;
        }
        int start = 0;
        int end = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                end = i;
            } else {
                if (end - start >= 2) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(start);
                    temp.add(end);
                    result.add(temp);
                }
                start = i;
                end = i;
            }
        }
        if (end - start >= 2) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(start);
            temp.add(end);
            result.add(temp);
        }
        return result;
    }
}