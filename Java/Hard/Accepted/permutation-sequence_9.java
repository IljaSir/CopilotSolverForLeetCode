class Solution {
    public String getPermutation(int n, int k) {
        
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        List<Integer> num = new ArrayList<>();
        num.add(0);
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
            num.add(i);
        }
        k--;
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            ans.append(num.get(index + 1));
            num.remove(index + 1);
            k = k - index * factorial[n - i];
        }
        return ans.toString();
    }
}