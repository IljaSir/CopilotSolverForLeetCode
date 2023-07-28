impl Solution {
    pub fn sum_base(n: i32, k: i32) -> i32 {
        
        let mut n = n;
        let mut s = 0;
        while n > 0 {
            s += n % k;
            n /= k;
        }
        s
    }
}