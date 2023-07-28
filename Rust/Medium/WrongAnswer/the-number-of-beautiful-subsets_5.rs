impl Solution {
    pub fn beautiful_subsets(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut dp = vec![0; 1 << nums.len()];
        for i in 0..nums.len() {
            let mut mask = 0;
            for j in i..nums.len() {
                if j > i && nums[j] - nums[j - 1] < k {
                    mask |= 1 << (j - 1);
                }
                dp[1 << j | mask] += 1;
            }
        }
        dp.iter().sum()
    }
}