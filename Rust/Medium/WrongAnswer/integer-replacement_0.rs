impl Solution {
    pub fn integer_replacement(n: i32) -> i32 {
        

        if n == 1 {
            return 0;
        }
        if n % 2 == 0 {
            return 1 + Self::integer_replacement(n / 2);
        }
        1 + Self::integer_replacement((n + 1) / 2).min(Self::integer_replacement((n - 1) / 2))
    }
}