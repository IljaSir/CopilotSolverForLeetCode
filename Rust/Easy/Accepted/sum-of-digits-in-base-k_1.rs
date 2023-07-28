impl Solution {
    pub fn sum_base(n: i32, k: i32) -> i32 {
        
        let mut n = n;
        let mut sum = 0;
        while n > 0 {
            sum += n % k;
            n /= k;
        }
        sum
    }
}