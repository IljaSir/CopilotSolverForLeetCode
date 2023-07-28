impl Solution {
    pub fn is_happy(n: i32) -> bool {
        
        let mut n = n;
        let mut seen = std::collections::HashSet::new();
        loop {
            if n == 1 {
                return true;
            }
            if seen.contains(&n) {
                return false;
            }
            seen.insert(n);
            n = n.to_string()
                .chars()
                .map(|c| c.to_digit(10).unwrap())
                .map(|d| d * d)
                .sum();
        }
    }
}