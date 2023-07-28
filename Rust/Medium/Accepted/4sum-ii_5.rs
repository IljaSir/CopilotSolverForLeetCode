impl Solution {
    pub fn four_sum_count(nums1: Vec<i32>, nums2: Vec<i32>, nums3: Vec<i32>, nums4: Vec<i32>) -> i32 {
        

        let mut res = 0;
        let mut map = std::collections::HashMap::new();
        for &n1 in &nums1 {
            for &n2 in &nums2 {
                *map.entry(n1 + n2).or_insert(0) += 1;
            }
        }
        for &n3 in &nums3 {
            for &n4 in &nums4 {
                if let Some(&v) = map.get(&(0 - n3 - n4)) {
                    res += v;
                }
            }
        }
        res
    }
}