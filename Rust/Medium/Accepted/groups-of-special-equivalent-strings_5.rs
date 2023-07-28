impl Solution {
    pub fn num_special_equiv_groups(words: Vec<String>) -> i32 {
        
        let mut ans = 0;
        let mut set = std::collections::HashSet::new();
        for word in words {
            let mut odd = Vec::new();
            let mut even = Vec::new();
            for (i, c) in word.bytes().enumerate() {
                if i % 2 == 0 {
                    even.push(c);
                } else {
                    odd.push(c);
                }
            }
            even.sort();
            odd.sort();
            let mut key = String::new();
            key.push_str(&String::from_utf8(odd).unwrap());
            key.push_str(&String::from_utf8(even).unwrap());
            if !set.contains(&key) {
                ans += 1;
                set.insert(key);
            }
        }
        ans
    }
}