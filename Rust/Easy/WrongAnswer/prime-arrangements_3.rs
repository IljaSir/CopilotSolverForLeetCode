impl Solution {
    pub fn num_prime_arrangements(n: i32) -> i32 {
        
        let mut count = 0;
        let mut i = 2;
        while i <= n {
            if Self::is_prime(i) {
                count += 1;
            }
            i += 1;
        }
        let mut a = 1;
        let mut b = 1;
        let mut i = 1;
        let mut j = 1;
        while i <= count {
            a = a * i % 1000000007;
            i += 1;
        }
        while j <= n - count {
            b = b * j % 1000000007;
            j += 1;
        }
        (a * b) % 1000000007
    }
    fn is_prime(n: i32) -> bool {
        let mut i = 2;
        while i * i <= n {
            if n % i == 0 {
                return false;
            }
            i += 1;
        }
        true
    }
}