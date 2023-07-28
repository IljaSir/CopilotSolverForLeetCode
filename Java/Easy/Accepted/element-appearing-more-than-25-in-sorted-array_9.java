class Solution {
    public int findSpecialInteger(int[] arr) {
        
        int len = arr.length;
        int count = 0;
        int cur = 0;
        for(int i = 0; i < len; i++) {
            if (arr[i] == cur) {
                count++;
            } else {
                cur = arr[i];
                count = 1;
            }
            if (count > len / 4) {
                return cur;
            }
        }
        return -1;
    }
}