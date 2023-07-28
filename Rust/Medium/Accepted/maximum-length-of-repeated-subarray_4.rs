impl Solution {
    pub fn find_length(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        

        let mut dp = vec![vec![0; nums2.len()+1]; nums1.len()+1];
        let mut res = 0;
        for i in 1..=nums1.len() {
            for j in 1..=nums2.len() {
                if nums1[i-1] == nums2[j-1] {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    res = res.max(dp[i][j]);
                }
            }
        }
        res
    }
}