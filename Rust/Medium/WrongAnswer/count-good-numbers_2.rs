impl Solution {
    pub fn count_good_numbers(n: i64) -> i32 {
        
        let m = 1_000_000_007;
        let mut ans = 1;
        for i in 0..n/2 {
            ans = ans * 20 % m;
        }
        if n % 2 == 1 {
            ans = ans * 5 % m;
        }
        ans as i32
    }
}