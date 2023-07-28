impl Solution {
    pub fn find_final_value(nums: Vec<i32>, original: i32) -> i32 {
        
        let mut original = original;
        for i in nums {
            if i == original {
                original *= 2;
            }
        }
        original
    }
}