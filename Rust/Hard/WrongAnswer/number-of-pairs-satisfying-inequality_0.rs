impl Solution {
    pub fn number_of_pairs(nums1: Vec<i32>, nums2: Vec<i32>, diff: i32) -> i64 {
        
        let mut ans = 0;
        let n = nums1.len();
        let mut nums1 = nums1;
        let mut nums2 = nums2;
        nums1.sort();
        nums2.sort();
        for i in 0..n {
            let mut l = i;
            let mut r = n - 1;
            while l < r {
                let m = (l + r + 1) / 2;
                if nums1[m] - nums1[i] <= nums2[i] - nums2[m] + diff {
                    l = m;
                } else {
                    r = m - 1;
                }
            }
            ans += (l - i) as i64;
        }
        ans
    }
}