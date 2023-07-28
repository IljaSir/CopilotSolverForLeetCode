impl Solution {
    pub fn min_operations(n: i32) -> i32 {
        
        let n = n as i64;
        (n * n / 4) as i32
    }
}