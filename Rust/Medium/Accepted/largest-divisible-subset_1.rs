impl Solution {
    pub fn largest_divisible_subset(nums: Vec<i32>) -> Vec<i32> {
        

        let mut nums = nums;
        nums.sort();
        let mut dp = vec![1; nums.len()];
        let mut max = 1;
        let mut max_index = 0;
        for i in 1..nums.len() {
            for j in 0..i {
                if nums[i] % nums[j] == 0 {
                    dp[i] = std::cmp::max(dp[i], dp[j] + 1);
                    if dp[i] > max {
                        max = dp[i];
                        max_index = i;
                    }
                }
            }
        }
        let mut res = Vec::new();
        let mut t = nums[max_index];
        let mut c = max;
        for i in (0..=max_index).rev() {
            if t % nums[i] == 0 && dp[i] == c {
                res.push(nums[i]);
                t = nums[i];
                c -= 1;
            }
        }
        res
    }
}