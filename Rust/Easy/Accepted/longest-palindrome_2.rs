impl Solution {
    pub fn longest_palindrome(s: String) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        s.chars().for_each(|c| {
            *map.entry(c).or_insert(0) += 1;
        });
        let mut result = 0;
        let mut has_odd = false;
        for (_, v) in map {
            if v % 2 == 0 {
                result += v;
            } else {
                has_odd = true;
                result += v - 1;
            }
        }
        if has_odd {
            result += 1;
        }
        result
    }
}