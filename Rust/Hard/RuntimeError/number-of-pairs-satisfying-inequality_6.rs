impl Solution {
    pub fn number_of_pairs(nums1: Vec<i32>, nums2: Vec<i32>, diff: i32) -> i64 {
        
        let mut res = 0;
        let mut nums2_sorted = nums2.clone();
        nums2_sorted.sort();
        for n in nums1 {
            let mut l = 0;
            let mut r = nums2_sorted.len() - 1;
            while l <= r {
                let m = (l + r) / 2;
                if nums2_sorted[m] < n - diff {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            res += l as i64;
        }
        res
    }
}