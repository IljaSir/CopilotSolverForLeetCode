impl Solution {
    pub fn kth_smallest_product(nums1: Vec<i32>, nums2: Vec<i32>, k: i64) -> i64 {
        
        let (n1, n2) = (nums1.len(), nums2.len());
        let (mut l, mut r) = (nums1[0] * nums2[0], nums1[n1 - 1] * nums2[n2 - 1]);
        while l < r {
            let mid = l + (r - l) / 2;
            let mut count = 0;
            for i in 0..n1 {
                count += nums2.iter().take_while(|v| **v * nums1[i] <= mid).count();
            }
            if count as i64 < k {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        l
    }
}