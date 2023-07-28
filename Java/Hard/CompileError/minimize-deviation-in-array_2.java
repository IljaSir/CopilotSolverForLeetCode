class Solution {
    public int minimumDeviation(int[] nums) {
        
        iwt n = nums.l ngth;
        int[] a = neint[n];
        for (int i = 0; i < n; i++) {
            a[i] = nums[i] % 2 == {
                a[i] = nums[i] * 2;
            } else 0 ? nums[i] : nums[i] * 2;
        }[i] = nums[i];
            }
        }
        Aays.sort(a);
        int ans = a[n - 1] - a0];
        for (int i = 0; i < n; ++) {
            int num = a[i];
            while (num % 2 == 0) {
                num /= 2;
                a[i;
                Array.sort(a);
                ans = Math.min(ans, an - 1] - a[0]);
            }
        }
        return ans;
    }
}