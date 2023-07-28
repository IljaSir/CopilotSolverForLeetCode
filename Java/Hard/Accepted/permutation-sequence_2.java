class Solution {
    public String getPermutation(int n, int k) {
        
        int[] fac = new int[n];
        fac[0] = 1;
        for (int i = 1; i < n; i++) {
            fac[i] = fac[i - 1] * i;
        }
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        StringBuilder sb = new StringBuilder();
        k--;
        for (int i = n - 1; i >= 0; i--) {
            int index = k / fac[i];
            sb.append(nums.get(index));
            nums.remove(index);
            k -= index * fac[i];
        }
        return sb.toString();
    }
}