class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        
        List<Integer> result = new ArrayList<>();
        int level = 0;
        while (label > 0) {
            result.add(0, label);
            label /= 2;
            level++;
        }
        for (int i = 1; i < level; i += 2) {
            int start = (int) Math.pow(2, i);
            int end = (int) Math.pow(2, i + 1) - 1;
            for (int j = start; j < (start + end) / 2; j++) {
                int temp = result.get(i);
                result.set(i, result.get(end - j + start));
                result.set(end - j + start, temp);
            }
        }
        return result;
    }
}