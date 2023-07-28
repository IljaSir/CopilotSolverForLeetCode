impl Solution {
    pub fn minimum_total_cost(nums1: Vec<i32>, nums2: Vec<i32>) -> i64 {
        
        let n = nums1.len();
        let mut dp = vec![vec![0; 3]; n];
        let mut ans = 0;
        for i in 0..n {
            let mut tmp = vec![0; 3];
            tmp[0] = dp[i][0] + i as i64;
            tmp[1] = dp[i][1] + i as i64;
            tmp[2] = dp[i][2] + i as i64;
            if nums1[i] != nums2[i] {
                tmp[0] = dp[i][0] + i as i64;
                tmp[1] = dp[i][1] + i as i64;
                tmp[2] = dp[i][2] + i as i64;
                if i == 0 {
                    tmp[0] = 0;
                    tmp[1] = 0;
                    tmp[2] = 0;
                } else {
                    tmp[0] = dp[i - 1][2] + i as i64;
                    tmp[1] = dp[i - 1][2] + i as i64;
                    tmp[2] = dp[i - 1][2] + i as i64;
                }
                if nums1[i] != nums1[i - 1] {
                    tmp[0] = min(tmp[0], dp[i][0] + i as i64);
                    tmp[1] = min(tmp[1], dp[i][0] + i as i64);
                    tmp[2] = min(tmp[2], dp[i][0] + i as i64);
                }
                if nums2[i] != nums2[i - 1] {
                    tmp[0] = min(tmp[0], dp[i][1] + i as i64);
                    tmp[1] = min(tmp[1], dp[i][1] + i as i64);
                    tmp[2] = min(tmp[2], dp[i][1] + i as i64);
                }
                if nums1[i] != nums2[i - 1] {
                    tmp[0] = min(tmp[0], dp[i][2] + i as i64);
                    tmp[1] = min(tmp[1], dp[i][2] + i as i64);
                    tmp[2] = min
    }
}