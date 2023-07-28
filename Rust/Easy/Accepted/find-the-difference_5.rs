impl Solution {
    pub fn find_the_difference(s: String, t: String) -> char {
        
        let mut sum = 0;
        for c in s.chars() {
            sum ^= c as i32;
        }
        for c in t.chars() {
            sum ^= c as i32;
        }
        sum as u8 as char
    }
}