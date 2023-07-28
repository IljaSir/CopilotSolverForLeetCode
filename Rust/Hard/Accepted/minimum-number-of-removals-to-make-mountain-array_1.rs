impl Solution {
    pub fn minimum_mountain_removals(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut dp1 = vec![1; n];
        let mut dp2 = vec![1; n];
        for i in 1..n {
            for j in 0..i {
                if nums[i] > nums[j] {
                    dp1[i] = dp1[i].max(dp1[j] + 1);
                }
            }
        }
        for i in (0..n - 1).rev() {
            for j in (i + 1)..n {
                if nums[i] > nums[j] {
                    dp2[i] = dp2[i].max(dp2[j] + 1);
                }
            }
        }
        let mut res = 0;
        for i in 0..n {
            if dp1[i] > 1 && dp2[i] > 1 {
                res = res.max(dp1[i] + dp2[i] - 1);
            }
        }
        (n - res) as i32
    }
}