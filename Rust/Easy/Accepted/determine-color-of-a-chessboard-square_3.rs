impl Solution {
    pub fn square_is_white(coordinates: String) -> bool {
        
        let mut iter = coordinates.chars();
        let col = iter.next().unwrap() as u8 - b'a';
        let row = iter.next().unwrap() as u8 - b'1';
        (col + row) % 2 == 1
    }
}