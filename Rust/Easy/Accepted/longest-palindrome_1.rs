impl Solution {
    pub fn longest_palindrome(s: String) -> i32 {
        
        let mut count = 0;
        let mut odd = false;
        let mut map = std::collections::HashMap::new();
        for c in s.chars() {
            *map.entry(c).or_insert(0) += 1;
        }
        for v in map.values() {
            if v % 2 == 0 {
                count += v;
            } else {
                count += v - 1;
                odd = true;
            }
        }
        if odd {
            count += 1;
        }
        count
    }
}