class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int n = arr.length;
        int l = 0, r = n - 1;
        while (r - l + 1 > k) {
            if (x - arr[l] > arr[r] - x) {
                l++;
            } else {
                r--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}