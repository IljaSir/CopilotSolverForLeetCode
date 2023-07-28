impl Solution {
    pub fn square_is_white(coordinates: String) -> bool {
        
        let c = coordinates.as_bytes();
        (c[0] - b'a' + c[1] - b'0') % 2 != 0
    }
}