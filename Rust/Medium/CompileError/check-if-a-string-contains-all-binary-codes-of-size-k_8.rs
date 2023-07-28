impl Solution {
    pub fn has_all_codes(s: String, k: i32) -> bool {
        
        let (s, k) = (s.into_bytes(), k as usize);
        let mut count = 0;
        let mut len = 0;
        let mut set = std::collections::HashSet::new();
        for (i, &c) in s.iter().enumerate() {
            len += 1;
            count = (count << 1) + (c - b'0') as usize;
            if len == k {
                set.insert(count);
                count -= (s[i - k + 1] - b'0') as usize << (k - 1);
                len -= 1;
            }
        }
        set.len() == 1 << k
    }
}