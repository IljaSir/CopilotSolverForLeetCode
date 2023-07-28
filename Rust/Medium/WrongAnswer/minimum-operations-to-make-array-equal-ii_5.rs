impl Solution {
    pub fn min_operations(nums1: Vec<i32>, nums2: Vec<i32>, k: i32) -> i64 {
        
        let k = k as usize;
        let mut nums1 = nums1;
        let mut nums2 = nums2;
        nums1.sort();
        nums2.sort();
        let mut diff = vec![];
        let mut i = 0;
        let mut j = 0;
        while i < nums1.len() && j < nums2.len() {
            if nums1[i] < nums2[j] {
                diff.push(nums2[j] - nums1[i]);
                i += 1;
            } else {
                diff.push(nums1[i] - nums2[j]);
                j += 1;
            }
        }
        while i < nums1.len() {
            diff.push(nums1[i]);
            i += 1;
        }
        while j < nums2.len() {
            diff.push(nums2[j]);
            j += 1;
        }
        let mut sum = 0;
        let mut min = std::i64::MAX;
        let mut left = 0;
        for right in 0..diff.len() {
            sum += diff[right] as i64;
            while sum > k as i64 {
                sum -= diff[left] as i64;
                left += 1;
            }
            if sum == k as i64 {
                min = std::cmp::min(min, diff[left..=right].iter().sum::<i32>() as i64);
            }
        }
        if min == std::i64::MAX {
            -1
        } else {
            min as i64
        }
    }
}