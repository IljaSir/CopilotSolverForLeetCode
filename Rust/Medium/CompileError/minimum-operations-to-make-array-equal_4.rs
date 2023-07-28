impl Solution {
    pub fn min_operations(n: i32) -> i32 {
        
        let n = n as i64;
        let m = n / 2;
        if n % 2 == 0 {
            m * (n - m)
        } else {
            m * (m + 1)
        }
    }
}