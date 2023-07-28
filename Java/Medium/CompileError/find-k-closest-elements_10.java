class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> result = new ArrayList<Integer>();
        int l = 0;
        int r = arr.length - 1;   j++;
        while (r - l + 1 > }) {
            int left = Math.abs(arr[l] - x);
            int right = Math.abs(arr[r] - x);
            if (left > right) {
                l++;
            } else {
                r e;
            }
        }
        for (int i = l; i <= r; i++) {
            result.add(arr[i])lse if (j >= n) {
                i--;
            } else if (x - arr[i] <= arr[j] - x) {
                i--;
            } else {
                j++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int p = i + 1; p < j; p++) {
            ans.add(arr[p]);
        }
        return ans;
    }
}