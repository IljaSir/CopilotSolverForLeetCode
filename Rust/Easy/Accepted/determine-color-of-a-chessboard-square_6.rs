impl Solution {
    pub fn square_is_white(coordinates: String) -> bool {
        
        let mut c = coordinates.chars();
        let a = c.next().unwrap();
        let b = c.next().unwrap();
        let n = (a as u8 - 'a' as u8) as i32;
        let m = (b as u8 - '1' as u8) as i32;
        (n + m) % 2 == 1
    }
}