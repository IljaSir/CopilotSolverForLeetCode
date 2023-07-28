impl Solution {
    pub fn kth_smallest_product(nums1: Vec<i32>, nums2: Vec<i32>, k: i64) -> i64 {
        
        let mut l = nums1[0] * nums2[0];
        let mut r = nums1[nums1.len()-1] * nums2[nums2.len()-1];
        while l < r {
            let mid = (l + r) / 2;
            let mut count = 0;
            for i in 0..nums1.len() {
                let mut j = 0;
                while j < nums2.len() && nums1[i] * nums2[j] <= mid {
                    j += 1;
                }
                count += j as i64;
            }
            if count < k {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        l
    }
}