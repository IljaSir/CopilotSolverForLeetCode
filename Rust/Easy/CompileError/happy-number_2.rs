impl Solution {
    pub fn is_happy(n: i32) -> bool {
        
        let mut n = n;
        let mut set = std::collections::HashSet::new();
        while n != 1 {
            if set.contains(&n) {
                return false;
            }
            set.insert(n);
            n = n.to_string().chars().map(|x| x.to_digit(10).unwrap()).map(|x| x * x).sum();
        }
        true
    }
}