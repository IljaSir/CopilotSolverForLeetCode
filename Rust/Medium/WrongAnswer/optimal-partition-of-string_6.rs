impl Solution {
    pub fn partition_string(s: String) -> i32 {
        
        let mut res = 0;
        let mut start = 0;
        let mut end = 0;
        let mut set = std::collections::HashSet::new();
        for (i, c) in s.chars().enumerate() {
            if set.contains(&c) {
                end = i;
            } else {
                set.insert(c);
                if i == s.len() - 1 {
                    res += 1;
                }
            }
            if end == i {
                res += 1;
                start = i + 1;
                end = i + 1;
                set.clear();
            }
        }
        res
    }
}