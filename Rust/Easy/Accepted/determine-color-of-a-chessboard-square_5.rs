impl Solution {
    pub fn square_is_white(coordinates: String) -> bool {
        
        let mut s = coordinates.chars();
        let x = s.next().unwrap() as i32;
        let y = s.next().unwrap() as i32;
        (x + y) % 2 == 1
    }
}