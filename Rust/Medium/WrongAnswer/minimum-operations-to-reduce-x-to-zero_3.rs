impl Solution {
    pub fn min_operations(nums: Vec<i32>, x: i32) -> i32 {
        
        let mut left = 0;
        let mut right = nums.len() - 1;
        let mut sum = 0;
        while sum < x && left <= right {
            if nums[left] < nums[right] {
                sum += nums[right];
                right -= 1;
            } else {
                sum += nums[left];
                left += 1;
            }
        }
        if sum == x {
            return (nums.len() - right - 1 + left) as i32;
        }
        let mut ans = -1;
        while left <= right {
            sum += nums[right];
            right -= 1;
            while sum > x && left <= right {
                sum -= nums[left];
                left += 1;
            }
            if sum == x {
                ans = (nums.len() - right - 1 + left) as i32;
            }
        }
        ans
    }
}