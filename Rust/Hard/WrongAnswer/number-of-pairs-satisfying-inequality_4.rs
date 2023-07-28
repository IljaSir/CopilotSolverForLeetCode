impl Solution {
    pub fn number_of_pairs(nums1: Vec<i32>, nums2: Vec<i32>, diff: i32) -> i64 {
        
        let (mut i, mut j) = (0, 0);
        let mut ans = 0;
        let mut nums2 = nums2;
        nums2.sort();
        for n1 in nums1 {
            while i < nums2.len() && n1 - nums2[i] > diff {
                i += 1;
            }
            while j < nums2.len() && n1 - nums2[j] >= diff {
                j += 1;
            }
            ans += (j - i) as i64;
        }
        ans
    }
}