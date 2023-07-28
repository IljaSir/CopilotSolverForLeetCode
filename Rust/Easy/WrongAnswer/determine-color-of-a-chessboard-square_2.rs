impl Solution {
    pub fn square_is_white(coordinates: String) -> bool {
        
        let mut chars = coordinates.chars();
        let c1 = chars.next().unwrap();
        let c2 = chars.next().unwrap();
        let c1 = c1 as i32 - 'a' as i32;
        let c2 = c2 as i32 - '1' as i32;
        (c1 + c2) % 2 == 0
    }
}