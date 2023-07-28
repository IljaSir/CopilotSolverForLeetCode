impl Solution {
    pub fn has_all_codes(s: String, k: i32) -> bool {
        
        let mut set = std::collections::HashSet::new();
        let k = k as usize;
        let s = s.as_bytes();
        for i in 0..=s.len() - k {
            set.insert(&s[i..i+k]);
        }
        set.len() == 1 << k
    }
}