impl Solution {
    pub fn min_operations(nums1: Vec<i32>, nums2: Vec<i32>, k: i32) -> i64 {
        
        let n = nums1.len();
        let mut sum1 = 0;
        let mut sum2 = 0;
        let mut diff = vec![0; 6 * n + 1];
        for i in 0..n {
            sum1 += nums1[i] as i64;
            sum2 += nums2[i] as i64;
            diff[nums1[i] as usize - nums2[i] as usize] += 1;
        }
        if sum1 > sum2 {
            return Self::min_operations(nums2, nums1, k);
        }
        let target = (sum2 - sum1) as usize;
        if target > 6 * n {
            return -1;
        }
        let mut ans = n as i64 + 1;
        let mut cur = 0;
        for i in 0..=6 * n {
            while cur <= 6 * n && i + cur <= target {
                ans = ans.min(cur as i64 + diff[i + cur]);
                cur += 1;
            }
            cur -= 1;
        }
        ans = ans.min(n as i64 + 1);
        if ans > n as i64 {
            -1
        } else {
            ans
        }
    }
}