impl Solution {
    pub fn valid_subarray_size(nums: Vec<i32>, threshold: i32) -> i32 {
        
        let mut sum = 0;
        let mut max = 0;
        for i in 0..nums.len() {
            sum += nums[i];
            if i > 0 {
                sum -= nums[i-1];
            }
            if i >= nums.len() - 1 {
                if sum > max {
                    max = sum;
                }
                sum -= nums[i + 1 - nums.len()];
            }
        }
        let mut k = 1;
        while max > threshold * k {
            k += 1;
        }
        if k > nums.len() {
            return -1;
        }
        k as i32
    }
}