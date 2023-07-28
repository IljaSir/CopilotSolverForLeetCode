class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = i + 1;
            while (j < s.length() && s.charAt(j) == s.charAt(j - 1)) {
                j++;
            }
            if (j - i >= 3) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(j - 1);
                result.add(list);
            }
            i = j;
        }
        return result;
    }
}