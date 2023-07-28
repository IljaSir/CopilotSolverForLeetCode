impl Solution {
    pub fn count_good_numbers(n: i64) -> i32 {
        
        let mut ans = 1;
        let mut n = n;
        while n > 0 {
            ans *= if n % 2 == 0 { 5 } else { 4 };
            ans %= 1_000_000_007;
            n /= 2;
        }
        ans as i32
    }
}