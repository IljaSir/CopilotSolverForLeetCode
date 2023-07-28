impl Solution {
    pub fn sum_base(n: i32, k: i32) -> i32 {
        
        let mut res = 0;
        let mut n = n;
        while n > 0 {
            res += n % k;
            n /= k;
        }
        res
    }
}