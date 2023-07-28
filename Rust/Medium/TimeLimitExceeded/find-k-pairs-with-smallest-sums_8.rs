impl Solution {
    pub fn k_smallest_pairs(nums1: Vec<i32>, nums2: Vec<i32>, k: i32) -> Vec<Vec<i32>> {
        

        let mut ans = Vec::new();
        let mut v = Vec::new();
        let mut i = 0;
        let mut j = 0;
        for i1 in nums1.iter() {
            for i2 in nums2.iter() {
                v.push((*i1, *i2));
            }
        }
        v.sort_by(|a, b| (a.0 + a.1).cmp(&(b.0 + b.1)));
        let mut k = k as usize;
        if k > v.len() {
            k = v.len();
        }
        for i in 0..k {
            ans.push(vec![v[i].0, v[i].1]);
        }
        ans
    }
}