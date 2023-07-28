impl Solution {
    pub fn count_good_substrings(s: String) -> i32 {
        
        let mut count = 0;
        let mut i = 0;
        let mut j = 0;
        let mut k = 0;
        let mut set = std::collections::HashSet::new();
        while k < s.len() {
            if set.contains(&s.as_bytes()[k]) {
                set.clear();
                i += 1;
                j = i;
                k = i;
            } else {
                set.insert(s.as_bytes()[k]);
                k += 1;
            }
            if k - j == 3 {
                count += 1;
                j += 1;
            }
        }
        count
    }
}