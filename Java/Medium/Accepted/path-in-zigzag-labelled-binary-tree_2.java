class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        
        List<Integer> result = new ArrayList<>();
        int level = 0;
        while (Math.pow(2, level) <= label) {
            level++;
        }
        while (level > 0) {
            result.add(0, label);
            label = (int) (Math.pow(2, level - 1) + Math.pow(2, level) - 1 - label) / 2;
            level--;
        }
        return result;
    }
}