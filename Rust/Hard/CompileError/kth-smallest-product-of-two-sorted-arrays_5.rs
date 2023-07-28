impl Solution {
    pub fn kth_smallest_product(nums1: Vec<i32>, nums2: Vec<i32>, k: i64) -> i64 {
        
        let (m, n) = (nums1.len(), nums2.len());
        let (mut left, mut right) = (nums1[0] * nums2[0], nums1[m - 1] * nums2[n - 1]);
        while left < right {
            let mid = left + (right - left) / 2;
            let mut count = 0;
            for i in 0..m {
                count += nums2.binary_search(&(mid / nums1[i])).unwrap_or(n) as i64;
            }
            if count < k {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        left
    }
}