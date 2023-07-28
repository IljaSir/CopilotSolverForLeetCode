impl Solution {
    pub fn longest_palindrome(s: String) -> i32 {
        
        let mut count = 0;
        let mut is_odd = false;
        let mut map = std::collections::HashMap::new();
        for c in s.chars() {
            let counter = map.entry(c).or_insert(0);
            *counter += 1;
        }
        for (_, v) in map {
            if v % 2 == 0 {
                count += v;
            } else {
                count += v - 1;
                is_odd = true;
            }
        }
        if is_odd {
            count += 1;
        }
        count
    }
}