impl Solution {
    pub fn kth_smallest_product(nums1: Vec<i32>, nums2: Vec<i32>, k: i64) -> i64 {
        
        let mut k = k as usize;
        let mut l = nums1[0] * nums2[0];
        let mut r = nums1[nums1.len()-1] * nums2[nums2.len()-1];
        while l < r {
            let m = l + (r - l) / 2;
            let mut cnt = 0;
            let mut j = nums2.len() - 1;
            for i in 0..nums1.len() {
                while j >= 0 && nums1[i] * nums2[j] > m {
                    j -= 1;
                }
                cnt += j + 1;
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