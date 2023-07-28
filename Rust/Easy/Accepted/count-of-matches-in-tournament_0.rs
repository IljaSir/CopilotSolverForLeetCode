impl Solution {
    pub fn number_of_matches(n: i32) -> i32 {
        
        if n == 1 {
            return 0;
        }
        if n % 2 == 0 {
            return n / 2 + Self::number_of_matches(n / 2);
        } else {
            return (n - 1) / 2 + Self::number_of_matches((n - 1) / 2 + 1);
        }
    }
}