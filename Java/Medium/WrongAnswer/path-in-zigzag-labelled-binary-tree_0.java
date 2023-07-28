class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        
        List<Integer> ans = new ArrayList<>();
        while (label != 0) {
            ans.add(label);
            label /= 2;
        }
        Collections.reverse(ans);
        for (int i = 1; i < ans.size(); i += 2) {
            int n = ans.get(i);
            int left = (1 << (i)) - 1;
            int right = (1 << (i + 1)) - 1;
            ans.set(i, left + right - n);
        }
        return ans;
    }
}