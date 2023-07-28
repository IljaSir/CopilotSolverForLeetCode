class Solution {
    public int[] threeEqualParts(int[] arr) {
        
        int n = arr.length;
        int ones = 0;
        for (int i = 0; i < n; i++) {
            ones += arr[i];
        }
        if (ones == 0) {
            return new int[] {0, n - 1};
        }
        if (ones % 3 != 0) {
            return new int[] {-1, -1};
        }
        int k = ones / 3;
        int i = 0;
        while (arr[i] == 0) {
            i++;
        }
        int j = i;
        while (k > 0) {
            k -= arr[j++];
        }
        int p1 = i;
        while (arr[p1] == 0) {
            p1++;
        }
        int p2 = j;
        while (p2 < n && arr[p1] == arr[p2]) {
            p1++;
            p2++;
        }
        if (p2 == n) {
            return new int[] {j - 1, p2};
        }
        return new int[] {-1, -1};
    }
}