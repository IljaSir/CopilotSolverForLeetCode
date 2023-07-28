impl Solution {
    pub fn number_of_pairs(nums1: Vec<i32>, nums2: Vec<i32>, diff: i32) -> i64 {
        
        let mut pairs = 0;
        let mut sorted_nums2 = nums2.clone();
        sorted_nums2.sort();
        for i in 0..nums1.len() {
            let upper_bound = nums1[i] - diff;
            let index = match sorted_nums2.binary_search(&upper_bound) {
                Ok(index) => index,
                Err(index) => index,
            };
            pairs += index as i64;
        }
        pairs
    }
}