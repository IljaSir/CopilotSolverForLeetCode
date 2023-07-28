impl Solution {
    pub fn is_happy(n: i32) -> bool {
        
        let mut n = n;
        let mut seen = std::collections::HashSet::new();
        while n != 1 {
            n = n.to_string().chars().map(|x| (x as u8 - b'0').pow(2)).sum();
            if seen.contains(&n) {
                return false;
            } else {
                seen.insert(n);
            }
        }
        true
    }
}