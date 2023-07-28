impl Solution {
    pub fn second_highest(s: String) -> i32 {
        
        let mut digits: Vec<i32> = s.chars().filter(|x| x.is_digit(10)).map(|x| x.to_digit(10).unwrap() as i32).collect();
        digits.sort_unstable();
        digits.dedup();
        if digits.len() > 1 {
            return digits[digits.len() - 2];
        }
        -1
    }
}