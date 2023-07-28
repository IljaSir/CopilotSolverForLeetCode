impl Solution {
    pub fn min_absolute_sum_diff(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut nums1 = nums1;
        let mut nums2 = nums2;
        let mut total = 0;
        for i in 0..nums1.len() {
            let diff = (nums1[i] - nums2[i]).abs();
            total += diff;
            nums1[i] = diff;
            nums2[i] = i as i32;
        }
        nums1.sort();
        nums2.sort();
        let mut i = 0;
        let mut j = 0;
        let mut best = 0;
        while i < nums1.len() && j < nums2.len() {
            let diff = (nums1[i] - nums2[j]).abs();
            if diff > best {
                best = diff;
            }
            if nums1[i] < nums2[j] {
                i += 1;
            } else {
                j += 1;
            }
        }
        (total - best) as i32 % 1_000_000_007
    }
}