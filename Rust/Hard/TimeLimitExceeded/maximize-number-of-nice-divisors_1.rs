impl Solution {
    pub fn max_nice_divisors(prime_factors: i32) -> i32 {
        
        let mut prime_factors = prime_factors as i64;
        let mut ans = 1;
        while prime_factors > 4 {
            ans = ans * 3 % 1000000007;
            prime_factors -= 3;
        }
        ans = ans * prime_factors % 1000000007;
        ans as i32
    }
}