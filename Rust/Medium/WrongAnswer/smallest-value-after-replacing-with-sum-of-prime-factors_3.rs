impl Solution {
    pub fn smallest_value(n: i32) -> i32 {
        
        let mut n = n;
        let mut sum = 0;
        let mut prime = 2;
        while n > 1 {
            if n % prime == 0 {
                sum += prime;
                n /= prime;
            } else {
                prime += 1;
            }
        }
        sum
    }
}