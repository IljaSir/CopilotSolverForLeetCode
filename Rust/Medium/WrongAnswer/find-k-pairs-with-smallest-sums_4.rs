impl Solution {
    pub fn k_smallest_pairs(nums1: Vec<i32>, nums2: Vec<i32>, k: i32) -> Vec<Vec<i32>> {
        

        let mut res = Vec::new();
        let mut i = 0;
        let mut j = 0;
        while (i < nums1.len() && j < nums2.len()) && res.len() < k as usize {
            res.push(vec![nums1[i], nums2[j]]);
            if i == nums1.len() - 1 {
                j += 1;
            } else if j == nums2.len() - 1 {
                i += 1;
            } else if nums1[i + 1] + nums2[j] < nums1[i] + nums2[j + 1] {
                i += 1;
            } else {
                j += 1;
            }
        }
        res
    }
}