impl Solution {
    pub fn sum_zero(n: i32) -> Vec<i32> {
        
        let mut result = Vec::new();
        let mut i = 1;
        while i <= n/2 {
            result.push(i);
            result.push(-i);
            i += 1;
        }
        if n % 2 == 1 {
            result.push(0);
        }
        result
    }
}