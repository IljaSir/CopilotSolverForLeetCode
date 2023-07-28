impl Solution {
    pub fn k_smallest_pairs(nums1: Vec<i32>, nums2: Vec<i32>, k: i32) -> Vec<Vec<i32>> {
        

        let mut ret = vec![];
        let mut i = 0;
        let mut j = 0;
        while i < nums1.len() && j < nums2.len() && ret.len() < k as usize {
            if nums1[i] + nums2[j] < nums1[i] + nums2[j + 1] {
                ret.push(vec![nums1[i], nums2[j]]);
                i += 1;
            } else {
                ret.push(vec![nums1[i], nums2[j + 1]]);
                j += 1;
            }
        }
        ret
    }
}