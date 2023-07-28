impl Solution {
    pub fn count_consistent_strings(allowed: String, words: Vec<String>) -> i32 {
        
        let mut count = 0;
        let mut allowed_set = std::collections::HashSet::new();
        for c in allowed.chars() {
            allowed_set.insert(c);
        }
        for word in words {
            let mut is_consistent = true;
            for c in word.chars() {
                if !allowed_set.contains(&c) {
                    is_consistent = false;
                    break;
                }
            }
            if is_consistent {
                count += 1;
            }
        }
        count
    }
}