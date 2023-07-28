class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        
        List<Integer> result = new ArrayList<>();
        int level = (int)(Math.log(label) / Math.log(2));
        int i = level;
        while (i >= 0) {
            result.add(0, label);
            int start = (int)Math.pow(2, i);
            int end = (int)Math.pow(2, i + 1) - 1;
            label = start + end - label;
            label = label / 2;
            i--;
        }
        return result;
    }
}