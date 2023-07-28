impl Solution {
    pub fn square_is_white(coordinates: String) -> bool {
        
        let mut odd = false;
        for c in coordinates.chars() {
            if c.is_ascii_alphabetic() {
                odd = c as u8 % 2 == 0;
            } else {
                odd = c as u8 % 2 != 0;
            }
        }
        odd
    }
}