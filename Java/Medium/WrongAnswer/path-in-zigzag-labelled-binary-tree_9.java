class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        
        List<Integer> result = new ArrayList<>();
        int level = 1;
        int count = 1;
        while (count <= label) {
            level++;
            count = count * 2;
        }
        level--;
        count = count / 2;
        int diff = label - count;
        int reverse = 0;
        while (level > 0) {
            int current = label;
            if (level % 2 == 0) {
                current = count - 1 - diff;
                result.add(0, current);
                diff = (current - 1) / 2;
            } else {
                result.add(0, current);
                diff = (current - 1) / 2;
            }
            level--;
            count = count / 2;
        }
        return result;
    }
}