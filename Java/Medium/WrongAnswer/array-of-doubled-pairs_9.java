class Solution {
    public boolean canReorderDoubled(int[] arr) {
        
        int n = arr.length;
        if (n % 2 != 0) return false;
        int[] a = new int[200001];
        for (int i = 0; i < n; ++i) {
            if (arr[i] < 0) {
                a[-arr[i] + 100000]++;
            } else {
                a[arr[i]]++;
            }
        }
        for (int i = 0; i < 100000; ++i) {
            if (a[i] > a[2 * i]) return false;
            a[2 * i] -= a[i];
        }
        return true;
    }
}