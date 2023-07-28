impl Solution {
    pub fn percentage_letter(s: String, letter: char) -> i32 {
        
        let mut count = 0;
        for c in s.chars() {
            if c == letter {
                count += 1;
            }
        }
        (count as f32 * 100.0 / s.len() as f32) as i32
    }
}