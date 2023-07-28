class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                if (j - i >= 3) {
                    List<Integer> interval = new ArrayList<Integer>();
                    interval.add(i);
                    interval.add(j - 1);
                    result.add(interval);
                }
                i = j;
            }
            j++;
        }
        if (j - i >= 3) {
            List<Integer> interval = new ArrayList<Integer>();
            interval.add(i);
            interval.add(j - 1);
            result.add(interval);
        }
        return result;
    }
}