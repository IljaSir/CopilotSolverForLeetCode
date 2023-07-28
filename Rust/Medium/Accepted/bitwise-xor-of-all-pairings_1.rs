impl Solution {
    pub fn xor_all_nums(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut res = 0;
        for i in nums1 {
            for j in &nums2 {
                res ^= i ^ j;
            }
        }
        res
    }
}