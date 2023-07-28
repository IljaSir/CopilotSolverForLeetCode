impl Solution {
    pub fn smaller_numbers_than_current(nums: Vec<i32>) -> Vec<i32> {
        
        let mut sorted = nums.clone();
        sorted.sort();
        nums.iter().map(|n| sorted.iter().position(|&m| m == *n).unwrap() as i32).collect()
    }
}