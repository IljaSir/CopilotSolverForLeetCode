impl Solution {
    pub fn find_final_value(nums: Vec<i32>, original: i32) -> i32 {
        
        let mut result = original;
        for num in nums {
            if num == result {
                result *= 2;
            }
        }
        result
    }
}