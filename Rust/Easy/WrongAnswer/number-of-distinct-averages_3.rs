impl Solution {
    pub fn distinct_averages(nums: Vec<i32>) -> i32 {
        
        let mut res = Vec::new();
        let mut nums = nums;
        nums.sort();
        let mut dp = vec![vec![false; nums.len() + 1]; nums.len() + 1];
        for i in 0..nums.len() {
            dp[i][i + 1] = true;
        }
        for i in (0..nums.len()).rev() {
            for j in (i + 2)..=nums.len() {
                for k in (i + 1)..j {
                    if dp[i][k] && dp[k][j] {
                        dp[i][j] = true;
                        break;
                    }
                }
                if dp[i][j] {
                    let sum = nums[i..j].iter().sum::<i32>() as f64;
                    let avg = sum / (j - i) as f64;
                    if !res.contains(&avg) {
                        res.push(avg);
                    }
                }
            }
        }
        res.len() as i32
    }
}