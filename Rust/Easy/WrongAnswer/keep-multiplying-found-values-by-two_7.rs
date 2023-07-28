impl Solution {
    pub fn find_final_value(nums: Vec<i32>, original: i32) -> i32 {
        
        let mut found = false;
        let mut result = original;
        for num in nums {
            if num == original {
                found = true;
                result *= 2;
            }
        }
        if found {
            result
        } else {
            original
        }
    }
}