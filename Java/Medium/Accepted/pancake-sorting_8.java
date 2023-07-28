class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        for (int i = n; i >= 2; i--) {
            int maxIdx = 0;
            for (int j = 1; j < i; j++) {
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }
            if (maxIdx == i - 1) {
                continue;
            }
            if (maxIdx != 0) {
                res.add(maxIdx + 1);
                reverse(arr, maxIdx);
            }
            res.add(i);
            reverse(arr, i - 1);
        }
        return res;
    }
    private void reverse(int[] arr, int i) {
        int l = 0, r = i;
        while (l < r) {
            int t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            l++;
            r--;
        }
    }
}