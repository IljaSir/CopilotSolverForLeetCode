class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        int n = s.length();
        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            if (j - i >= 3) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j - 1);
                res.add(temp);
            }));
        }
        return result;
    }
}