impl Solution {
    pub fn min_operations(nums1: Vec<i32>, nums2: Vec<i32>, k: i32) -> i64 {
        
        let mut nums1 = nums1;
        let mut nums2 = nums2;
        nums1.sort();
        nums2.sort();
        let mut nums1_sum = 0;
        let mut nums2_sum = 0;
        for i in 0..nums1.len() {
            nums1_sum += nums1[i];
            nums2_sum += nums2[i];
        }
        let diff = nums1_sum + nums2_sum - k;
        if diff < 0 {
            return -1;
        }
        if diff == 0 {
            return 0;
        }
        let mut i = 0;
        let mut j = nums1.len() - 1;
        let mut res = i64::MAX;
        let mut sum = 0;
        while i < nums1.len() {
            while j >= 0 && (nums1[i] - nums2[j]).abs() <= diff {
                sum += (nums1[i] - nums2[j]).abs();
                j -= 1;
            }
            if sum == diff {
                res = res.min((i + 1) as i64 + (nums1.len() - 1 - j) as i64);
            }
            sum -= nums1[i];
            i += 1;
        }
        if res == i64::MAX {
            return -1;
        }
        res
    }
}