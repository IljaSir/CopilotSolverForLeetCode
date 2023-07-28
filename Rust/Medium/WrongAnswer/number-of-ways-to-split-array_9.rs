impl Solution {
    pub fn ways_to_split_array(nums: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let mut sum_left = 0;
        let mut sum_right = 0;
        let mut ans = 0;
        let mut left = 0;
        let mut right = 0;
        let mut mid = 0;
        let mut i = 0;
        let mut j = 0;
        let mut k = 0;
        let mut n = nums.len();
        let mut left_max = 0;
        let mut right_min = 0;
        let mut mod_num = 1000000007;
        for i in 0..n {
            sum += nums[i];
        }
        for i in 0..n {
            sum_left += nums[i];
            left = i;
            right = n - 1;
            sum_right = sum - sum_left;
            while left < right {
                mid = (left + right) / 2;
                if sum_left <= sum_right - nums[mid] {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if right == n - 1 {
                continue;
            }
            left_max = i;
            right_min = right;
            while left_max + 1 < right_min {
                mid = (left_max + right_min) / 2;
                if sum_left - nums[mid] <= sum_right - nums[right_min] {
                    right_min = mid;
                } else {
                    left_max = mid;
                }
            }
            ans += right_min - left_max;
            ans %= mod_num;
        }
        ans as i32
    }
}