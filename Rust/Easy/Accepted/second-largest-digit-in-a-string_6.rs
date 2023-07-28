impl Solution {
    pub fn second_highest(s: String) -> i32 {
        
        let mut digits = vec![];
        for ch in s.chars() {
            if ch.is_digit(10) {
                digits.push(ch.to_digit(10).unwrap() as i32);
            }
        }
        if digits.is_empty() {
            return -1;
        }
        digits.sort();
        digits.dedup();
        if digits.len() == 1 {
            return -1;
        }
        digits[digits.len() - 2]
    }
}