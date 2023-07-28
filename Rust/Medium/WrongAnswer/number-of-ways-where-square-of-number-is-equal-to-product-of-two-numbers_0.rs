impl Solution {
    pub fn num_triplets(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut m1 = std::collections::HashMap::new();
        let mut m2 = std::collections::HashMap::new();
        for i in 0..nums1.len() {
            for j in i+1..nums1.len() {
                let k = nums1[i] * nums1[j];
                let v = m1.entry(k).or_insert(0);
                *v += 1;
            }
        }
        for i in 0..nums2.len() {
            for j in i+1..nums2.len() {
                let k = nums2[i] * nums2[j];
                let v = m2.entry(k).or_insert(0);
                *v += 1;
            }
        }
        for i in 0..nums1.len() {
            let k = nums1[i] * nums1[i];
            if let Some(v) = m2.get(&k) {
                ans += v;
            }
        }
        for i in 0..nums2.len() {
            let k = nums2[i] * nums2[i];
            if let Some(v) = m1.get(&k) {
                ans += v;
            }
        }
        ans
    }
}