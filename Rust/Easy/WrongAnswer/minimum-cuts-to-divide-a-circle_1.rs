impl Solution {
    pub fn number_of_cuts(n: i32) -> i32 {
        
        ((n as f64).sin() * n as f64).ceil() as i32
    }
}