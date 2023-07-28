impl Solution {
    pub fn square_is_white(coordinates: String) -> bool {
        
        let (c1, c2) = (coordinates.chars().nth(0).unwrap(), coordinates.chars().nth(1).unwrap());
        let r = (c1 as u8 - b'a') + (c2 as u8 - b'1');
        r % 2 == 1
    }
}