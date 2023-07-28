class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        
        List<Integer> list = new ArrayList<>();
        int level = (int) (Math.log(label) / Math.log(2));
        int current = label;
        while (level >= 0) {
            list.add(current);
            int lower = (int) Math.pow(2, level);
            int upper = (int) Math.pow(2, level + 1) - 1;
            int parent = (upper + lower - current) / 2;
            current = parent;
            level--;
        }
        Collections.reverse(list);
        return list;
    }
}