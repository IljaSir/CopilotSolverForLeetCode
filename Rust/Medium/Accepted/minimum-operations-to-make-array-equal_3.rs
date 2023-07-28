impl Solution {
    pub fn min_operations(n: i32) -> i32 {
        
        (n / 2) * (n / 2 + n % 2)
    }
}