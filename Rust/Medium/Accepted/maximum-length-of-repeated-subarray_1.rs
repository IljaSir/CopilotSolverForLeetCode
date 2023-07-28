impl Solution {
    pub fn find_length(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        

        let (n, m) = (nums1.len(), nums2.len());
        let mut dp = vec![vec![0; m + 1]; n + 1];
        let mut ans = 0;
        for i in 0..n {
            for j in 0..m {
                if nums1[i] == nums2[j] {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    ans = ans.max(dp[i + 1][j + 1]);
                }
            }
        }
        ans as i32
    }
}