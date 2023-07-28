impl Solution {
    pub fn smallest_value(n: i32) -> i32 {
        
        let mut n = n;
        let mut ans = n;
        let mut i = 2;
        while i * i <= n {
            if n % i == 0 {
                ans -= ans / i;
                while n % i == 0 {
                    n /= i;
                }
            }
            i += 1;
        }
        if n > 1 {
            ans -= ans / n;
        }
        ans
    }
}