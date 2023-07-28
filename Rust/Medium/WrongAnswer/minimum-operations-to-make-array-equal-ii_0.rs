impl Solution {
    pub fn min_operations(nums1: Vec<i32>, nums2: Vec<i32>, k: i32) -> i64 {
        
        let (n, m) = (nums1.len(), nums2.len());
        let (mut sum1, mut sum2) = (0, 0);
        for i in 0..n {
            sum1 += nums1[i] as i64;
        }
        for i in 0..m {
            sum2 += nums2[i] as i64;
        }
        if sum1 < sum2 {
            return Self::min_operations(nums2, nums1, k);
        }
        if sum1 - sum2 < k as i64 {
            return -1;
        }
        let mut nums1: Vec<i64> = nums1.into_iter().map(|x| x as i64).collect();
        let mut nums2: Vec<i64> = nums2.into_iter().map(|x| x as i64).collect();
        nums1.sort();
        nums2.sort();
        let mut diff: Vec<i64> = Vec::new();
        for i in 0..n {
            diff.push(nums1[i] - 1);
        }
        for i in 0..m {
            diff.push(6 - nums2[i]);
        }
        diff.sort();
        let mut ans = 0;
        for i in 0..(k as usize) {
            ans += diff[i];
        }
        ans as i64
    }
}