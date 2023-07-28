class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        
        List<List<Integer>> result = new ArrayList<>();
        if (s.length() < 3) {
            return result;
        }
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                end++;
            } else {
                if (end - start + 1 >= 3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(end);
                    result.add(list);
                }
                start = i;
                end = i;
            }
        }
        if (end - start + 1 >= 3) {
            List<Integer> list = new ArrayList<>();
            list.add(start);
            list.add(end);
            result.add(list);
        }
        return result;
    }
}