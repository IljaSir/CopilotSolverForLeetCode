impl Solution {
    pub fn distinct_averages(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut dp = vec![vec![false; nums.len()]; nums.len()];
        let mut ans = 0;
        for i in 0..nums.len() {
            for j in i..nums.len() {
                if i == j {
                    dp[i][j] = true;
                    ans += 1;
                } else {
                    let mut k = i;
                    while k < j {
                        if dp[i][k] && dp[k + 1][j] {
                            let mut l = k + 1;
                            while l < j {
                                if nums[l] == nums[k + 1] {
                                    l += 1;
                                } else {
                                    break;
                                }
                            }
                            if nums[j] == nums[k] {
                                dp[i][j] = true;
                                ans += 1;
                                break;
                            } else {
                                k = l;
                            }
                        } else {
                            k += 1;
                        }
                    }
                }
            }
        }
        ans
    }
}