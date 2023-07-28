impl Solution {
    pub fn four_sum_count(nums1: Vec<i32>, nums2: Vec<i32>, nums3: Vec<i32>, nums4: Vec<i32>) -> i32 {
        

        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        for i in nums1.iter() {
            for j in nums2.iter() {
                *map.entry(i + j).or_insert(0) += 1;
            }
        }
        for i in nums3.iter() {
            for j in nums4.iter() {
                if let Some(v) = map.get(&(-i - j)) {
                    count += v;
                }
            }
        }
        count
    }
}