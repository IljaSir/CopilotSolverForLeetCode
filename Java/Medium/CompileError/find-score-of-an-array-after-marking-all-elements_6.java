class Solution {
    public long findScore(int[] nums) {
        
        long score = 0;
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 0;
        right[n - 1] = n - 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                left[i] = i - 1;
            } else {
                int j = i - 1;
                while (j >= 0 && arr[i] <= arr[j]) {
                    j = left[j];
                }
                left[i] = j;
            }
        }] = 0;
                }
            }
        }
        return score;
    }
}