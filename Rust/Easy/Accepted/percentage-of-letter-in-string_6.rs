impl Solution {
    pub fn percentage_letter(s: String, letter: char) -> i32 {
        
        let mut n = 0;
        for c in s.chars() {
            if c == letter {
                n += 1;
            }
        }
        (n as f64 / s.len() as f64 * 100.0) as i32
    }
}