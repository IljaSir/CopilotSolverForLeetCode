impl Solution {
    pub fn maximum_value(strs: Vec<String>) -> i32 {
        
        strs.iter().map(|s| {
            if s.chars().all(|c| c.is_digit(10)) {
                s.parse::<i32>().unwrap()
            } else {
                s.len() as i32
            }
        }).max().unwrap()
    }
}