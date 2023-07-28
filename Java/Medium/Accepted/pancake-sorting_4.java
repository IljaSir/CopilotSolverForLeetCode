class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        
        List<Integer> ans = new ArrayList<>();
        for (int i = arr.length; i > 0; i--) {
            int idx = find(arr, i);
            if (idx == i - 1) continue;
            if (idx > 0) {
                flip(arr, idx + 1);
                ans.add(idx + 1);
            }
            flip(arr, i);
            ans.add(i);
        }
        return ans;
    }
    private int find(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }
    private void flip(int[] arr, int k) {
        for (int i = 0; i < k / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[k - i - 1];
            arr[k - i - 1] = temp;
        }
    }
}