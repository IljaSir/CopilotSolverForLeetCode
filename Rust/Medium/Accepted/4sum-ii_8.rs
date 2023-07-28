impl Solution {
    pub fn four_sum_count(nums1: Vec<i32>, nums2: Vec<i32>, nums3: Vec<i32>, nums4: Vec<i32>) -> i32 {
        

        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        
        for i in nums1.iter() {
            for j in nums2.iter() {
                let sum = i + j;
                *map.entry(sum).or_insert(0) += 1;
            }
        }
        
        for i in nums3.iter() {
            for j in nums4.iter() {
                let sum = i + j;
                if let Some(val) = map.get(&(-sum)) {
                    count += val;
                }
            }
        }
        
        count
    }
}