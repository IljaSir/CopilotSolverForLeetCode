impl Solution {
    pub fn valid_subarray_size(nums: Vec<i32>, threshold: i32) -> i32 {
        
        let mut l = 1;
        let mut r = nums.len() as i32;
        while l <= r {
            let m = (l + r) / 2;
            if Self::is_valid(&nums, threshold, m) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        r
    }
    fn is_valid(nums: &Vec<i32>, threshold: i32, size: i32) -> bool {
        let mut sum = nums[..size as usize].iter().sum::<i32>();
        if sum > threshold * size {
            return true;
        }
        for i in size as usize..nums.len() {
            sum += nums[i];
            sum -= nums[i - size as usize];
            if sum > threshold * size {
                return true;
            }
        }
        false
    }
}