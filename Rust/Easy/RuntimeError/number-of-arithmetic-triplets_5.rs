impl Solution {
    pub fn arithmetic_triplets(nums: Vec<i32>, diff: i32) -> i32 {
        
        let mut res = 0;
        let mut dp = vec![0; 201];
        let mut cnt = vec![0; 201];
        for num in nums {
            if num - diff >= 0 {
                res += dp[(num - diff) as usize];
            }
            dp[num as usize] += cnt[(num - diff) as usize];
            cnt[num as usize] += 1;
        }
        res
    }
}