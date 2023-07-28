class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        
        List<Integer> result = new ArrayList<>();
        while (label != 1) {
            result.add(label);
            label = label / 2;
        }
        result.add(1);
        Collections.reverse(result);
        for (int i = 0; i < result.size(); i++) {
            if (i % 2 == 1) {
                result.set(i, (1 << i + 1) - 1 - result.get(i) + (1 << i));
            }
        }
        return result;
    }
}