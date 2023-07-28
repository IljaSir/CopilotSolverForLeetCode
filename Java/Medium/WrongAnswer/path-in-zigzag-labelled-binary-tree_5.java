class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        
        List<Integer> ans = new ArrayList<>();
        int row = (int)(Math.log(label) / Math.log(2)) + 1;
        int rowStart = (int)Math.pow(2, row - 1);
        int rowEnd = (int)Math.pow(2, row) - 1;
        while (row > 0) {
            ans.add(label);
            if (row % 2 == 0) {
                label = rowStart + rowEnd - label;
            }
            label /= 2;
            row--;
            rowStart /= 2;
            rowEnd /= 2;
        }
        Collections.reverse(ans);
        return ans;
    }
}