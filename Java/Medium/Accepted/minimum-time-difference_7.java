class Solution {
    public int findMinDifference(List<String> timePoints) {
        
        List<Integer> list = new ArrayList<>();
        for (String s : timePoints) {
            String[] ss = s.split(":");
            int h = Integer.valueOf(ss[0]);
            int m = Integer.valueOf(ss[1]);
            list.add(h * 60 + m);
        }
        Collections.sort(list);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }
        min = Math.min(min, 1440 - list.get(list.size() - 1) + list.get(0));
        return min;
    }
}