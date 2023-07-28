impl Solution {
    pub fn find_final_value(nums: Vec<i32>, original: i32) -> i32 {
        
        let mut result = original;
        for n in nums {
            if n == result {
                result *= 2;
            }
        }
        result
    }
}