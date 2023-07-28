impl Solution {
    pub fn valid_subarray_size(nums: Vec<i32>, threshold: i32) -> i32 {
        
        let mut l = 1;
        let mut r = nums.len();
        while l < r {
            let m = (l + r) / 2;
            let mut sum = 0;
            for i in 0..m {
                sum += nums[i];
            }
            let mut valid = sum > threshold * m as i32;
            for i in m..nums.len() {
                sum += nums[i];
                sum -= nums[i - m];
                if sum > threshold * m as i32 {
                    valid = true;
                    break;
                }
            }
            if valid {
                l = m + 1;
            } else {
                r = m;
            }
        }
        if l == nums.len() {
            -1
        } else {
            l as i32
        }
    }
}