class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        
        List<Integer> ans = new ArrayList<>();
        ans.add(start);
        for (int i = 0; i < n; i++) {
            int size = ans.size();
            int add = 1 << i;
            for (int j = size - 1; j >= 0; j--) {
                ans.add(add + ans.get(j));
            }
        }
        return ans;
    }
}