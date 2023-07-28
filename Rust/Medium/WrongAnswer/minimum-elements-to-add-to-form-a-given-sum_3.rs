impl Solution {
    pub fn min_elements(nums: Vec<i32>, limit: i32, goal: i32) -> i32 {
        
        let sum = nums.iter().sum::<i32>();
        let diff = (goal - sum).abs();
        (diff as f64 / limit as f64).ceil() as i32
    }
}