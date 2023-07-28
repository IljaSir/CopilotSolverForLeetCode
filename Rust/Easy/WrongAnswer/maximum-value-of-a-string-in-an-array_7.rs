impl Solution {
    pub fn maximum_value(strs: Vec<String>) -> i32 {
        
        strs.iter().map(|s| s.chars().fold(0, |acc, c| if c.is_digit(10) { acc } else { acc + 1 })).max().unwrap()
    }
}