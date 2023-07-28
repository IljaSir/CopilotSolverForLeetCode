impl Solution {
    pub fn kth_smallest_product(nums1: Vec<i32>, nums2: Vec<i32>, k: i64) -> i64 {
        
        let mut left = nums1[0] * nums2[0];
        let mut right = nums1[nums1.len() - 1] * nums2[nums2.len() - 1];
        let mut mid = 0;
        let mut count = 0;
        while left < right {
            mid = (left + right) / 2;
            count = 0;
            for i in 0..nums1.len() {
                count += nums2.binary_search(&(mid / nums1[i])).unwrap_or_else(|x| x) as i64;
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