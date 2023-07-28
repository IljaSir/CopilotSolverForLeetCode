impl Solution {
    pub fn min_swaps(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut ones = 0;
        for i in 0..n {
            ones += nums[i];
        }
        let mut cur = 0;
        for i in 0..ones {
            cur += nums[i];
        }
        let mut res = ones - cur;
        for i in 1..n {
            cur += nums[(i + ones - 1) % n] - nums[i - 1];
            res = res.min(ones - cur);
        }
        res as i32
    }
}