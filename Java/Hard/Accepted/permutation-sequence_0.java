class Solution {
    public String getPermutation(int n, int k) {
        
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            f[i] = f[i - 1] * i;
        }
        k--;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int pos = k / f[n - i];
            sb.append(list.get(pos));
            list.remove(pos);
            k -= pos * f[n - i];
        }
        return sb.toString();
    }
}