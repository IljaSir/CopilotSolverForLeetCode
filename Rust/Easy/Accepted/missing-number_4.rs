impl Solution {
    pub fn missing_number(nums: Vec<i32>) -> i32 {
        
        let n = nums.len() as i32;
        let sum = nums.iter().fold(0, |acc, x| acc + x);
        (n * (n + 1)) / 2 - sum
    }
}