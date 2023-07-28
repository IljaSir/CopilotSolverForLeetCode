impl Solution {
    pub fn square_is_white(coordinates: String) -> bool {
        
        let mut sum = 0;
        let mut count = 0;
        for c in coordinates.chars() {
            if c.is_digit(10) {
                sum += c.to_digit(10).unwrap();
            } else {
                sum += c as u32 - 'a' as u32 + 1;
            }
            count += 1;
            if count == 2 {
                break;
            }
        }
        sum % 2 == 0
    }
}