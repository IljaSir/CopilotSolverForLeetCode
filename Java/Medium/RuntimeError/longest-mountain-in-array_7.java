class Solution {
    public int longestMountain(int[] arr) {
        
        int max = 0;
        int start = 0;
        int end = 0;
        while (end < arr.length) {
            if (arr[end] > arr[end + 1]) {
                if (start == end) {
                    start++;
                    end++;
                } else {
                    end++;
                    while (end < arr.length && arr[end] < arr[end + 1]) {
                        end++;
                    }
                    max = Math.max(max, end - start + 1);
                    start = end;
                }
            } else if (arr[end] < arr[end + 1]) {
                end++;
            } else {
                start++;
                end++;
            }
        }
        return max;
    }
}