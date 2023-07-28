class Solution {
    public String getPermutation(int n, int k) {
        
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = i * factorial[i - 1];
        }
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        StringBuilder sb = new StringBuilder();
        k--;
        for (int i = n - 1; i >= 0; i--) {
            int index = k / factorial[i];
            sb.append(nums.get(index));
            nums.remove(index);
            k -= index * factorial[i];
        }
        return sb.toString();
    }
}