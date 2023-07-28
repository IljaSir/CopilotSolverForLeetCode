impl Solution {
    pub fn min_elements(nums: Vec<i32>, limit: i32, goal: i32) -> i32 {
        
        let sum = nums.iter().fold(0, |acc, x| acc + x);
        let diff = (goal - sum).abs();
        (diff + limit - 1) / limit
    }
}