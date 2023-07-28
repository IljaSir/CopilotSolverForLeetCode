impl Solution {
    pub fn has_all_codes(s: String, k: i32) -> bool {
        
        let k = k as usize;
        let mut set = std::collections::HashSet::new();
        let mut i = 0;
        while i + k <= s.len() {
            set.insert(&s[i..i+k]);
            i += 1;
        }
        set.len() == 1 << k
    }
}