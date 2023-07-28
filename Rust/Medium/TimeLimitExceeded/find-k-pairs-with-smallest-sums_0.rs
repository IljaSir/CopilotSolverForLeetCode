impl Solution {
    pub fn k_smallest_pairs(nums1: Vec<i32>, nums2: Vec<i32>, k: i32) -> Vec<Vec<i32>> {
        

        let mut pairs = Vec::new();
        let mut i = 0;
        while i < nums1.len() {
            let mut j = 0;
            while j < nums2.len() {
                pairs.push(vec![nums1[i], nums2[j]]);
                j += 1;
            }
            i += 1;
        }
        pairs.sort_by(|a, b| (a[0] + a[1]).cmp(&(b[0] + b[1])));
        pairs.truncate(k as usize);
        pairs
    }
}