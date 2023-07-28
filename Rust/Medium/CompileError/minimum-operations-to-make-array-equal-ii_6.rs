impl Solution {
    pub fn min_operations(nums1: Vec<i32>, nums2: Vec<i32>, k: i32) -> i64 {
        
        let n = nums1.len();
        let mut sum1 = 0;
        let mut sum2 = 0;
        let mut diff = vec![0; 6 * n + 1];
        let mut cnt = vec![0; 6 * n + 1];
        for i in 0..n {
            sum1 += nums1[i];
            sum2 += nums2[i];
            let d = (nums1[i] - nums2[i]).abs();
            diff[d as usize] += 1;
        }
        let mut res = 0;
        let mut l = 0;
        let mut r = 0;
        let mut max_cnt = 0;
        while r <= 6 * n {
            if r - l + 1 > k as usize {
                cnt[diff[l as usize]] -= 1;
                max_cnt = max_cnt.max(cnt[diff[l as usize]]);
                l += 1;
            }
            if r - l + 1 == k as usize {
                res += max_cnt + 1;
            }
            cnt[diff[r as usize]] += 1;
            max_cnt = max_cnt.max(cnt[diff[r as usize]]);
            r += 1;
        }
        if sum1 == sum2 {
            res -= 1;
        } else if sum1 > sum2 {
            res -= (sum1 - sum2) / 2;
        } else {
            res -= (sum2 - sum1) / 2;
        }
        res
    }
}