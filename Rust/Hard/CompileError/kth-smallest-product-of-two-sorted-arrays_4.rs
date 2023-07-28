impl Solution {
    pub fn kth_smallest_product(nums1: Vec<i32>, nums2: Vec<i32>, k: i64) -> i64 {
        
        let n1 = nums1.len();
        let n2 = nums2.len();
        let mut l = nums1[0] * nums2[0];
        let mut r = nums1[n1 - 1] * nums2[n2 - 1];
        while l < r {
            let m = l + (r - l) / 2;
            let mut cnt = 0;
            for i in 0..n1 {
                cnt += nums2.binary_search(&((m / nums1[i]) + 1)).unwrap_or_else(|x| x) as i64;
            }
            if cnt < k {
                l = m + 1;
            } else {
                r = m;
            }
        }
        l
    }
}