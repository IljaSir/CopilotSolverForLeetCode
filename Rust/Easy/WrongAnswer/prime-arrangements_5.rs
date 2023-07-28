impl Solution {
    pub fn num_prime_arrangements(n: i32) -> i32 {
        
        let mut prime = 0;
        let mut not_prime = 0;
        for i in 1..=n {
            if Self::is_prime(i) {
                prime += 1;
            } else {
                not_prime += 1;
            }
        }
        let mut ans = 1;
        let mut modu = 1000000007;
        for i in 1..=prime {
            ans = (ans * i) % modu;
        }
        for i in 1..=not_prime {
            ans = (ans * i) % modu;
        }
        ans
    }
    fn is_prime(n: i32) -> bool {
        if n < 2 {
            return false;
        }
        if n == 2 {
            return true;
        }
        if n % 2 == 0 {
            return false;
        }
        for i in 3..=n / 2 {
            if n % i == 0 {
                return false;
            }
        }
        true
    }
}