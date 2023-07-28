impl Solution {
    pub fn minimum_xor_sum(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let n = nums1.len();
        let mut dp = vec![vec![std::i32::MAX; 1 << n]; n];
        Self::dfs(&nums1, &nums2, 0, 0, &mut dp)
    }
    fn dfs(nums1: &Vec<i32>, nums2: &Vec<i32>, i: usize, mask: usize, dp: &mut Vec<Vec<i32>>) -> i32 {
        if i == nums1.len() {
            return 0;
        }
        if dp[i][mask] != std::i32::MAX {
            return dp[i][mask];
        }
        let mut best = std::i32::MAX;
        for j in 0..nums2.len() {
            if (1 << j) & mask == 0 {
                best = best.min((nums1[i] ^ nums2[j]) + Self::dfs(nums1, nums2, i + 1, mask | (1 << j), dp));
            }
        }
        dp[i][mask] = best;
        best
    }
}