class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        
        List<Integer> ans = new ArrayList();
        ans.add(label);
        while (label != 1) {
            label = label / 2;
            int row = (int)(Math.log(label) / Math.log(2));
            int max = (int)Math.pow(2, row + 1) - 1;
            label = max - label + max / 2;
            ans.add(label);
        }
        Collections.reverse(ans);
        return ans;
    }
}