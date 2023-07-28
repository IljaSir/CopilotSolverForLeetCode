class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int[] f = new int[n];
        int[]   mark[j] = Math.min(mark[j], mark[i]);
                j++;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (mark[i] == i) {
                res++;
            }
        }
        return res;
    }
}