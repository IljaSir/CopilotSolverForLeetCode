impl Solution {
    pub fn number_of_arithmetic_slices(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let n = nums.len();
        let mut dp = vec![vec![0; n]; n];
        let mut m = std::collections::HashMap::new();
        for i in 0..n {
            for j in i+1..n {
                let d = nums[j] as i64 - nums[i] as i64;
                let mut count = 1;
                if let Some(&v) = m.get(&(d, nums[i])) {
                    count += v;
                    ans += v;
                }
                dp[i][j] = count;
                *m.entry((d, nums[j])).or_insert(0) += count;
            }
        }
        ans
    }
}