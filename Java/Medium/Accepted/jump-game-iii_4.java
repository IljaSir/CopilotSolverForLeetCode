class Solution {
    public boolean canReach(int[] arr, int start) {
        
        if (arr[start] == 0) {
            return true;
        }
        if (arr[start] == -1) {
            return false;
        }
        int val = arr[start];
        arr[start] = -1;
        if (start + val < arr.length && canReach(arr, start + val)) {
            return true;
        }
        if (start - val >= 0 && canReach(arr, start - val)) {
            return true;
        }
        return false;
    }
}