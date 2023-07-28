class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        
        List<List<Integer>> list = new ArrayList<>();
        int start = 0;
        int end = 0;
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                count++;
                end++;
            } else {
                if (count >= 3) {
                    List<Integer> l = new ArrayList<>();
                    l.add(start);
                    l.add(end);
                    list.add(l);
                }
                start = i;
                end = i;
                count = 1;
            }
        }
        if (count >= 3) {
            List<Integer> l = new ArrayList<>();
            l.add(start);
            l.add(end);
            list.add(l);
        }
        return list;
    }
}