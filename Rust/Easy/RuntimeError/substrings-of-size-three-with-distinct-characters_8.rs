impl Solution {
    pub fn count_good_substrings(s: String) -> i32 {
        
        let mut count = 0;
        for i in 0..s.len() - 2 {
            let mut set = std::collections::HashSet::new();
            let mut is_good = true;
            for c in s[i..i+3].chars() {
                if set.contains(&c) {
                    is_good = false;
                    break;
                } else {
                    set.insert(c);
                }
            }
            if is_good {
                count += 1;
            }
        }
        count
    }
}