impl Solution {
    pub fn num_special_equiv_groups(words: Vec<String>) -> i32 {
        
        let mut count = 0;
        let mut set = std::collections::HashSet::new();
        for word in words {
            let mut odd = Vec::new();
            let mut even = Vec::new();
            for (i, c) in word.chars().enumerate() {
                if i % 2 == 0 {
                    even.push(c);
                } else {
                    odd.push(c);
                }
            }
            even.sort();
            odd.sort();
            let mut key = String::new();
            for c in even {
                key.push(c);
            }
            for c in odd {
                key.push(c);
            }
            if !set.contains(&key) {
                set.insert(key);
                count += 1;
            }
        }
        count
    }
}