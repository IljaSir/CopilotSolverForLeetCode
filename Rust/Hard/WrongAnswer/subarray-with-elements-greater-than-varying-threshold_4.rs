impl Solution {
    pub fn valid_subarray_size(nums: Vec<i32>, threshold: i32) -> i32 {
        
        let mut l = 1;
        let mut r = nums.len();
        while l < r {
            let m = (l + r) / 2;
            if Self::valid(&nums, m, threshold) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        if Self::valid(&nums, l, threshold) {
            l as i32
        } else {
            -1
        }
    }
    fn valid(nums: &Vec<i32>, k: usize, threshold: i32) -> bool {
        let mut sum = 0;
        for i in 0..k {
            sum += nums[i];
        }
        if sum >= threshold {
            return true;
        }
        for i in k..nums.len() {
            sum += nums[i] - nums[i - k];
            if sum >= threshold {
                return true;
            }
        }
        false
    }
}