impl Solution {
    pub fn circular_array_loop(nums: Vec<i32>) -> bool {
        

        let n = nums.len();
        let mut dp = vec![false; n];
        for i in 0..n {
            if dp[i] {
                continue;
            }
            let mut j = i;
            let mut k = i;
            let mut dir = 0;
            while !dp[j] {
                dp[j] = true;
                k = (j as i32 + nums[j]) as usize % n;
                if nums[j] * nums[k] < 0 {
                    break;
                }
                if dir == 0 {
                    if nums[j] > 0 {
                        dir = 1;
                    } else {
                        dir = -1;
                    }
                } else if dir * nums[j] < 0 {
                    break;
                }
                if j == k {
                    if j == (j as i32 + nums[j]) as usize % n {
                        break;
                    }
                    return true;
                }
                j = k;
            }
        }
        false
    }
}