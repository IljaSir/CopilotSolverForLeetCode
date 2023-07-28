impl Solution {
    pub fn prime_palindrome(n: i32) -> i32 {
        
        if n <= 2 {
            return 2;
        }
        if n <= 3 {
            return 3;
        }
        if n <= 5 {
            return 5;
        }
        if n <= 7 {
            return 7;
        }
        if n <= 11 {
            return 11;
        }
        let mut i = n;
        while i < 100000000 {
            if Solution::is_prime(i) && Solution::is_palindrome(i) {
                return i;
            }
            i += 1;
        }
        0
    }
    fn is_prime(n: i32) -> bool {
        if n % 2 == 0 {
            return false;
        }
        let mut i = 3;
        while i * i <= n {
            if n % i == 0 {
                return false;
            }
            i += 2;
        }
        true
    }
    fn is_palindrome(n: i32) -> bool {
        let mut n = n;
        let mut res = 0;
        while n > res {
            res = res * 10 + n % 10;
            n /= 10;
        }
        n == res || n == res / 10
    }
}