impl Solution {
    pub fn k_smallest_pairs(nums1: Vec<i32>, nums2: Vec<i32>, k: i32) -> Vec<Vec<i32>> {
        

        let mut ans = Vec::new();
        let mut i = 0;
        let mut j = 0;
        while ans.len() < k as usize {
            if i >= nums1.len() {
                ans.push(vec![nums1[i - 1], nums2[j]]);
                j += 1;
                continue;
            }
            if j >= nums2.len() {
                ans.push(vec![nums1[i], nums2[j - 1]]);
                i += 1;
                continue;
            }
            if nums1[i] <= nums2[j] {
                ans.push(vec![nums1[i], nums2[j]]);
                i += 1;
            } else {
                ans.push(vec![nums1[i], nums2[j]]);
                j += 1;
            }
        }
        ans
    }
}