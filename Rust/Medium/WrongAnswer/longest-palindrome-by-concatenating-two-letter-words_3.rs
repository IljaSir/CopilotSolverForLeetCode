impl Solution {
    pub fn longest_palindrome(words: Vec<String>) -> i32 {
        
        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        for w in words {
            let mut chars = w.chars();
            let c1 = chars.next().unwrap();
            let c2 = chars.next().unwrap();
            if c1 == c2 {
                count += 2;
            } else {
                map.entry(c1).or_insert(0);
                map.entry(c2).or_insert(0);
                *map.get_mut(&c1).unwrap() += 1;
                *map.get_mut(&c2).unwrap() += 1;
            }
        }
        let mut odd = 0;
        for v in map.values() {
            if v % 2 == 1 {
                odd += 1;
            }
        }
        if odd > 0 {
            count + odd - 1
        } else {
            count
        }
    }
}