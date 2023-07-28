impl Solution {
    pub fn four_sum_count(nums1: Vec<i32>, nums2: Vec<i32>, nums3: Vec<i32>, nums4: Vec<i32>) -> i32 {
        

        let mut m = std::collections::HashMap::new();
        let mut ans = 0;
        for &a in nums1.iter() {
            for &b in nums2.iter() {
                *m.entry(a + b).or_insert(0) += 1;
            }
        }
        for &c in nums3.iter() {
            for &d in nums4.iter() {
                if let Some(v) = m.get(&(0 - c - d)) {
                    ans += v;
                }
            }
        }
        ans
    }
}