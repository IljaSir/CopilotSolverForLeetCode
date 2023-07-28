impl Solution {
    pub fn longest_palindrome(words: Vec<String>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for w in words {
            let w = w.as_bytes();
            let key = (w[0], w[1]);
            let key2 = (w[1], w[0]);
            let c = map.entry(key).or_insert(0);
            *c += 1;
            if key != key2 {
                let c = map.entry(key2).or_insert(0);
                *c += 1;
            }
        }
        let mut ans = 0;
        let mut has_single = false;
        for (k, v) in map {
            if v % 2 == 0 {
                ans += v;
            } else {
                ans += v - 1;
                if k.0 == k.1 {
                    has_single = true;
                }
            }
        }
        if has_single {
            ans += 1;
        }
        ans
    }
}