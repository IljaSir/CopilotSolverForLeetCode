impl Solution {
    pub fn square_is_white(coordinates: String) -> bool {
        
        let mut c = coordinates.chars();
        let x = c.next().unwrap() as u8;
        let y = c.next().unwrap() as u8;
        
        (x + y) % 2 == 1
    }
}