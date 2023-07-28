impl Solution {
    pub fn find_final_value(nums: Vec<i32>, original: i32) -> i32 {
        
        let mut x = original;
        for i in 0..nums.len() {
            if x == nums[i] {
                x *= 2;
            }
        }
        return x;
    }
}