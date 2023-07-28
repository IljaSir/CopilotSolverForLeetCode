impl Solution {
    pub fn minimal_k_sum(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut nums = nums;
        nums.sort();
        let mut sum = 0;
        let mut i = 0;
        while i < nums.len() && nums[i] <= k as i32 {
            sum += nums[i] as i64;
            i += 1;
        }
        sum + (k - i as i32) as i64
    }
}