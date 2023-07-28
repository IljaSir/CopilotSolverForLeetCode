impl Solution {
    pub fn num_special_equiv_groups(words: Vec<String>) -> i32 {
        
        use std::collections::HashSet;
        let mut set = HashSet::new();
        for word in words {
            let mut even = Vec::new();
            let mut odd = Vec::new();
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
            set.insert(key);
        }
        set.len() as i32
    }
}