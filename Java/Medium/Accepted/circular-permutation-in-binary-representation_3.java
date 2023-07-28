class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        
        List<Integer> ans = new ArrayList<>();
        ans.add(start);
        for (int i = 0; i < n; i++) {
            int size = ans.size();
            for (int j = size - 1; j >= 0; j--) {
                ans.add(ans.get(j) ^ (1 << i));
            }
        }
        return ans;
    }
}