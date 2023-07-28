impl Solution {
    pub fn min_operations(n: i32) -> i32 {
        
        let n = n as i64;
        let mut sum = 0;
        for i in 0..n/2 {
            sum += n - 2*i - 1;
        }
        sum
    }
}