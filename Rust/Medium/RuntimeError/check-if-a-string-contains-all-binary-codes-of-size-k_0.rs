impl Solution {
    pub fn has_all_codes(s: String, k: i32) -> bool {
        
        let mut set = std::collections::HashSet::new();
        for i in 0..=(s.len() - k as usize) {
            set.insert(&s[i..i + k as usize]);
        }
        set.len() == 1 << k
    }
}