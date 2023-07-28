impl Solution {
    pub fn longest_palindrome(s: String) -> i32 {
        
        let mut count = 0;
        let mut flag = false;
        let mut map = std::collections::HashMap::new();
        for c in s.chars() {
            let counter = map.entry(c).or_insert(0);
            *counter += 1;
        }
        for (_, v) in map.iter() {
            if v % 2 == 0 {
                count += v;
            } else {
                flag = true;
                count += v - 1;
            }
        }
        if flag {
            count += 1;
        }
        count
    }
}