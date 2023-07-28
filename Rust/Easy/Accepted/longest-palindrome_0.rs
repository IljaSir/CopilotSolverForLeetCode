impl Solution {
    pub fn longest_palindrome(s: String) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for c in s.chars() {
            let count = map.entry(c).or_insert(0);
            *count += 1;
        }
        let mut ans = 0;
        let mut has_odd = false;
        for (_, v) in map {
            if v % 2 == 0 {
                ans += v;
            } else {
                ans += v - 1;
                has_odd = true;
            }
        }
        if has_odd {
            ans + 1
        } else {
            ans
        }
    }
}