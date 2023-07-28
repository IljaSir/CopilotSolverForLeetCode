impl Solution {
    pub fn two_egg_drop(n: i32) -> i32 {
        
        let n = n as f64;
        let x = (1.0 + (1.0 + 8.0 * n).sqrt()) / 2.0;
        x.floor() as i32
    }
}