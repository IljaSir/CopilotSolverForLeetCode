impl Solution {
    pub fn min_operations(nums1: Vec<i32>, nums2: Vec<i32>, k: i32) -> i64 {
        
        let n = nums1.len() as i64;
        let k = k as i64;
        let mut sum1 = 0;
        let mut sum2 = 0;
        for i in 0..n {
            sum1 += nums1[i as usize] as i64;
            sum2 += nums2[i as usize] as i64;
        }
        let diff = (sum1 - sum2).abs() as i64;
        if diff > k * 5 {
            return -1;
        }
        let mut cnt = vec![0; 6];
        for i in 0..n {
            cnt[(nums1[i as usize] - nums2[i as usize]).abs() as usize] += 1;
        }
        let mut ans = k;
        let mut cur = 0;
        for i in 1..6 {
            cur += cnt[i];
            if diff >= i as i64 * cur {
                ans = k - cur;
            }
        }
        ans
    }
}