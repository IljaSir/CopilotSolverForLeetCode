impl Solution {
    pub fn kth_smallest_product(nums1: Vec<i32>, nums2: Vec<i32>, k: i64) -> i64 {
        
        let mut lo = nums1[0] * nums2[0];
        let mut hi = nums1[nums1.len() - 1] * nums2[nums2.len() - 1];
        while lo < hi {
            let mid = lo + (hi - lo) / 2;
            let mut cnt = 0;
            for &n1 in &nums1 {
                if n1 * nums2[0] > mid {
                    break;
                }
                cnt += nums2.binary_search(&((mid / n1) + 1)).unwrap_or_else(|x| x) as i64;
            }
            if cnt < k {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        lo
    }
}