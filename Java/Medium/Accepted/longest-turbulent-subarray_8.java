class Solution {
    public int maxTurbulenceSize(int[] arr) {
        
        int max = 1;
        int curr = 1;
        for (int i = 1; i < arr.length; i++) {
            if (i % 2 == 1) {
                if (arr[i] > arr[i - 1]) {
                    curr++;
                } else {
                    curr = 1;
                }
            } else {
                if (arr[i] < arr[i - 1]) {
                    curr++;
                } else {
                    curr = 1;
                }
            }
            max = Math.max(max, curr);
        }
        curr = 1;
        for (int i = 1; i < arr.length; i++) {
            if (i % 2 == 1) {
                if (arr[i] < arr[i - 1]) {
                    curr++;
                } else {
                    curr = 1;
                }
            } else {
                if (arr[i] > arr[i - 1]) {
                    curr++;
                } else {
                    curr = 1;
                }
            }
            max = Math.max(max, curr);
        }
        return max;
    }
}