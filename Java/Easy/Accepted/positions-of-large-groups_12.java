class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        
        List<List<Integer>> result = new ArrayList<>();
        if (s == null || s.length() < 3) {
            return result;
        }
        char[] chars = s.toCharArray();
        int start = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[start]) {
                if (i - start >= 3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(i - 1);
                    result.add(list);
                }
                start = i;
            }
        }
        if (chars.length - start >= 3) {
            List<Integer> list = new ArrayList<>();
            list.add(start);
            list.add(chars.length - 1);
            result.add(list);
        }
        return result;
    }
}