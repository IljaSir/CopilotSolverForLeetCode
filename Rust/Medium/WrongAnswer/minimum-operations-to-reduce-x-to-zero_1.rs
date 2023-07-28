impl Solution {
    pub fn min_operations(nums: Vec<i32>, x: i32) -> i32 {
        
        let n = nums.len();
        let mut sum = 0;
        let mut ans = -1;
        let mut left = 0;
        for right in 0..n {
            sum += nums[right];
            while sum > x && left <= right {
                sum -= nums[left];
                left += 1;
            }
            if sum == x {
                ans = ans.max((right - left + 1) as i32);
            }
        }
        if ans < 0 {
            return -1;
        }
        n as i32 - ans
    }
}