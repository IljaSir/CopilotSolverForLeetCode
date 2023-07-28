impl Solution {
    pub fn valid_subarray_size(nums: Vec<i32>, threshold: i32) -> i32 {
        
        let mut left = 1;
        let mut right = nums.len() as i32;
        let mut ans = -1;
        while left <= right {
            let mid = left + (right - left) / 2;
            let mut sum = 0;
            for i in 0..mid as usize {
                sum += nums[i];
            }
            if sum >= threshold {
                ans = mid;
                right = mid - 1;
            } else {
                for i in mid as usize..nums.len() {
                    sum += nums[i] - nums[i - mid as usize];
                    if sum >= threshold {
                        ans = mid;
                        right = mid - 1;
                        break;
                    }
                }
            }
            if ans == -1 {
                left = mid + 1;
            }
        }
        ans
    }
}