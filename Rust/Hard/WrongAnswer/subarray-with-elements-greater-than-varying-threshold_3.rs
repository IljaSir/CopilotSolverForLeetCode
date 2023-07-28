impl Solution {
    pub fn valid_subarray_size(nums: Vec<i32>, threshold: i32) -> i32 {
        
        let mut left = 0;
        let mut right = nums.len();
        let mut sum = nums.iter().sum::<i32>();
        while left < right {
            let mid = (left + right) / 2;
            if sum > threshold * mid as i32 {
                left = mid + 1;
            } else {
                right = mid;
            }
            sum -= nums[mid];
        }
        if left == nums.len() {
            -1
        } else {
            left as i32
        }
    }
}