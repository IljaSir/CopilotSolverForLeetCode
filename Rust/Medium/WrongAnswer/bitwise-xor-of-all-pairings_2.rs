impl Solution {
    pub fn xor_all_nums(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut result = 0;
        for i in 0..nums1.len() {
            let mut tmp = nums1[i];
            for j in 0..nums2.len() {
                result ^= tmp ^ nums2[j];
                tmp = tmp ^ nums2[j];
            }
        }
        result
    }
}