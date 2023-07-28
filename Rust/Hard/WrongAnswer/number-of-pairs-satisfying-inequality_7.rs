impl Solution {
    pub fn number_of_pairs(nums1: Vec<i32>, nums2: Vec<i32>, diff: i32) -> i64 {
        
        let mut res = 0i64;
        let mut nums2 = nums2;
        nums2.sort();
        for i in 0..nums1.len() {
            let mut left = 0;
            let mut right = nums2.len();
            while left < right {
                let mid = left + (right - left) / 2;
                if nums1[i] - nums2[mid] > diff {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            res += left as i64;
        }
        res
    }
}