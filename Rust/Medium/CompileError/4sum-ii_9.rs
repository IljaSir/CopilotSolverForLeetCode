impl Solution {
    pub fn four_sum_count(nums1: Vec<i32>, nums2: Vec<i32>, nums3: Vec<i32>, nums4: Vec<i32>) -> i32 {
        

        let mut sum = 0;
        let mut sum_map = std::collections::HashMap::new();
        for i in 0..nums1.len() {
            for j in 0..nums2.len() {
                let sum = nums1[i] + nums2[j];
                let count = sum_map.entry(sum).or_insert(0);
                *count += 1;
            }
        }
        for i in 0..nums3.len() {
            for j in 0..nums4.len() {
                let sum = -(nums3[i] + nums4[j]);
                if let Some(count) = sum_map.get(&sum) {
                    sum += count;
                }
            }
        }
        sum
    }
}