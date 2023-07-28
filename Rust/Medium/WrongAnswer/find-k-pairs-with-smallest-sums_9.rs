impl Solution {
    pub fn k_smallest_pairs(nums1: Vec<i32>, nums2: Vec<i32>, k: i32) -> Vec<Vec<i32>> {
        

        let mut res = Vec::new();
        let mut i = 0;
        let mut j = 0;
        let mut k = k;
        let mut sum = Vec::new();
        while k > 0 && i < nums1.len() && j < nums2.len() {
            let s = nums1[i] + nums2[j];
            let mut pos = sum.len();
            while pos > 0 && sum[pos - 1] > s {
                pos -= 1;
            }
            sum.insert(pos, s);
            res.insert(pos, vec![nums1[i], nums2[j]]);
            if i + 1 < nums1.len() && nums1[i + 1] + nums2[j] <= s {
                i += 1;
            } else if j + 1 < nums2.len() && nums1[i] + nums2[j + 1] <= s {
                j += 1;
            } else {
                i += 1;
                j += 1;
            }
            k -= 1;
        }
        res
    }
}