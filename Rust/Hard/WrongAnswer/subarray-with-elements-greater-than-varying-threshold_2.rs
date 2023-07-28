impl Solution {
    pub fn valid_subarray_size(nums: Vec<i32>, threshold: i32) -> i32 {
        
        let n = nums.len();
        let mut sum = 0;
        for i in 0..n {
            sum += nums[i];
        }
        let mut k = n;
        while k > 0 {
            if sum / k as i32 >= threshold {
                return k as i32;
            }
            sum -= nums[n - k];
            k -= 1;
        }
        -1
    }
}