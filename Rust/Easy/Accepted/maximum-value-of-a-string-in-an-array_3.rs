impl Solution {
    pub fn maximum_value(strs: Vec<String>) -> i32 {
        
        strs.iter().map(|s| {
            if s.chars().any(|c| c.is_alphabetic()) {
                s.len() as i32
            } else {
                s.parse::<i32>().unwrap()
            }
        }).max().unwrap_or(0)
    }
}