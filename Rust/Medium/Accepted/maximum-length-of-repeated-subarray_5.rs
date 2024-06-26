impl Solution {
    pub fn find_length(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        

        let mut dp = vec![vec![0; nums2.len() + 1]; nums1.len() + 1];
        let mut ans = 0;
        for i in (0..nums1.len()).rev() {
            for j in (0..nums2.len()).rev() {
                if nums1[i] == nums2[j] {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                    ans = ans.max(dp[i][j]);
                }
            }
        }
        ans
    }
}