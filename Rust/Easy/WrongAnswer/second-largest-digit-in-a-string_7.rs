impl Solution {
    pub fn second_highest(s: String) -> i32 {
        
        let mut digits = s.chars().filter(|c| c.is_digit(10)).map(|c| c.to_digit(10).unwrap()).collect::<Vec<u32>>();
        digits.sort();
        digits.dedup();
        digits.pop().unwrap_or(0) as i32
    }
}