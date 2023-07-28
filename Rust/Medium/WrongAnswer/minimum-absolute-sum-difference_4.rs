impl Solution {
    pub fn min_absolute_sum_diff(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut nums1 = nums1;
        let mut nums2 = nums2;
        let mut diff = 0;
        for i in 0..nums1.len() {
            diff += (nums1[i] - nums2[i]).abs();
            nums1[i] -= nums2[i];
        }
        let mut max_diff = 0;
        for i in 0..nums1.len() {
            let mut tmp_max_diff = 0;
            for j in 0..nums1.len() {
                if (nums1[i] - nums1[j]).abs() > tmp_max_diff {
                    tmp_max_diff = (nums1[i] - nums1[j]).abs();
                }
            }
            if tmp_max_diff > max_diff {
                max_diff = tmp_max_diff;
            }
        }
        (diff - max_diff) % 1000000007
    }
}