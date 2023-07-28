impl Solution {
    pub fn k_smallest_pairs(nums1: Vec<i32>, nums2: Vec<i32>, k: i32) -> Vec<Vec<i32>> {
        

        let mut res: Vec<Vec<i32>> = Vec::new();
        let (mut i, mut j) = (0, 0);
        let (mut p1, mut p2) = (0, 0);
        let (mut k, mut count) = (k, 0);
        while k > 0 {
            let (mut v1, mut v2) = (0, 0);
            if i < nums1.len() {
                v1 = nums1[i];
            }
            if j < nums2.len() {
                v2 = nums2[j];
            }
            if v1 + v2 < nums1[p1] + nums2[p2] {
                p1 = i;
                p2 = j;
            }
            if j + 1 < nums2.len() {
                j += 1;
            } else {
                i += 1;
                j = 0;
            }
            count += 1;
            if count == k {
                res.push(vec![nums1[p1], nums2[p2]]);
                count = 0;
                k -= 1;
            }
        }
        res
    }
}