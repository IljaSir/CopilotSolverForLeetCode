class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        
        int level = (int)(Math.log(label)/Math.log(2));
        List<Integer> path = new ArrayList<Integer>();
        while (level >= 0) {
            path.add(0, label);
            label = (int)((Math.pow(2, level) + Math.pow(2, level + 1) - 1 - label) / 2);
            level--;
        }
        return path;
    }
}