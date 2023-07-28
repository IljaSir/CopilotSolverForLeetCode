impl Solution {
    pub fn min_sum_square_diff(nums1: Vec<i32>, nums2: Vec<i32>, k1: i32, k2: i32) -> i64 {
        
        let mut nums1 = nums1;
        let mut nums2 = nums2;
        nums1.sort();
        nums2.sort();
        let mut i = 0;
        let mut j = 0;
        let mut k = k1;
        let mut l = k2;
        let mut ans = 0;
        while i < nums1.len() && j < nums2.len() {
            let diff = (nums1[i] - nums2[j]).abs();
            if diff == 0 {
                i += 1;
                j += 1;
            } else if nums1[i] > nums2[j] {
                if l > 0 {
                    ans += diff as i64 * diff as i64;
                    j += 1;
                    l -= 1;
                } else {
                    ans += (nums1[i] - nums2[j]) as i64 * (nums1[i] - nums2[j]) as i64;
                    i += 1;
                    j += 1;
                }
            } else {
                if k > 0 {
                    ans += diff as i64 * diff as i64;
                    i += 1;
                    k -= 1;
                } else {
                    ans += (nums1[i] - nums2[j]) as i64 * (nums1[i] - nums2[j]) as i64;
                    i += 1;
                    j += 1;
                }
            }
        }
        ans
    }
}