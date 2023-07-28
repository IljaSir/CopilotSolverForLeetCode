impl Solution {
    pub fn has_all_codes(s: String, k: i32) -> bool {
        
        let k = k as usize;
        let mut set = std::collections::HashSet::new();
        for i in 0..=(s.len() - k) {
            set.insert(&s[i..i + k]);
        }
        set.len() == 1 << k
    }
}