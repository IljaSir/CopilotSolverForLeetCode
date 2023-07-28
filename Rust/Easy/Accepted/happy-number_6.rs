impl Solution {
    pub fn is_happy(n: i32) -> bool {
        
        let mut n = n;
        let mut hash = std::collections::HashSet::new();
        while n != 1 {
            let mut sum = 0;
            while n > 0 {
                let digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
            if hash.contains(&n) {
                return false;
            }
            hash.insert(n);
        }
        true
    }
}