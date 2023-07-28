impl Solution {
    pub fn minimum_xor_sum(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let n = nums1.len();
        let mut dp = vec![vec![0; 1 << n]; n];
        for i in 0..n {
            for j in 0..(1 << n) {
                dp[i][j] = -1;
            }
        }
        Self::dfs(0, 0, &nums1, &nums2, &mut dp)
    }
    fn dfs(i: usize, mask: usize, nums1: &Vec<i32>, nums2: &Vec<i32>, dp: &mut Vec<Vec<i32>>) -> i32 {
        let n = nums1.len();
        if i == n {
            return 0;
        }
        if dp[i][mask] != -1 {
            return dp[i][mask];
        }
        let mut ans = std::i32::MAX;
        for j in 0..n {
            if (mask & (1 << j)) == 0 {
                ans = ans.min(Self::dfs(i + 1, mask | (1 << j), nums1, nums2, dp) + (nums1[i] ^ nums2[j]));
            }
        }
        dp[i][mask] = ans;
        ans
    }
}