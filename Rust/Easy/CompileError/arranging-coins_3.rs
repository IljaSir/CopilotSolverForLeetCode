impl Solution {
    pub fn arrange_coins(n: i32) -> i32 {
        
        (((2 * n as i64 + 0.25) as f64).sqrt() - 0.5) as i32
    }
}