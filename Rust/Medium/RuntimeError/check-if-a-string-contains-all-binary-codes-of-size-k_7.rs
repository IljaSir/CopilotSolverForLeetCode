impl Solution {
    pub fn has_all_codes(s: String, k: i32) -> bool {
        
        let k = k as usize;
        let mut count = 0;
        let mut visited = vec![false; 1 << k];
        let mut i = 0;
        let mut j = 0;
        let mut num = 0;
        let mut base = 1 << (k - 1);
        while j < s.len() {
            if s.as_bytes()[j] == b'1' {
                num += base;
            }
            if j - i + 1 == k {
                if !visited[num] {
                    visited[num] = true;
                    count += 1;
                }
                if s.as_bytes()[i] == b'1' {
                    num -= base;
                }
                i += 1;
            }
            j += 1;
        }
        count == 1 << k
    }
}