impl Solution {
    pub fn min_operations(n: i32) -> i32 {
        
        if n % 2 == 0 {
            n * n / 4
        } else {
            n * (n - 1) / 4
        }
    }
}