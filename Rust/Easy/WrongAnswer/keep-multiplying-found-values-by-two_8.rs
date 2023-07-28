impl Solution {
    pub fn find_final_value(nums: Vec<i32>, original: i32) -> i32 {
        
        nums.iter().fold(original, |acc, x| if *x == acc {acc*2} else {acc})
    }
}