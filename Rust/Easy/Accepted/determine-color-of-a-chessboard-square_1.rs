impl Solution {
    pub fn square_is_white(coordinates: String) -> bool {
        
        let c = coordinates.as_bytes();
        let c1 = c[0] - b'a';
        let c2 = c[1] - b'1';
        (c1 + c2) % 2 == 1
    }
}