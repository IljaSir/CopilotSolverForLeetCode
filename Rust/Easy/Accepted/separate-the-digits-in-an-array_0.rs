impl Solution {
    pub fn separate_digits(nums: Vec<i32>) -> Vec<i32> {
        
        nums.iter().map(|n| n.to_string().chars().map(|c| c.to_digit(10).unwrap() as i32).collect::<Vec<i32>>()).flatten().collect()
    }
}