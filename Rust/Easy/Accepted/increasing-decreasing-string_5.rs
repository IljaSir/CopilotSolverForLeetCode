impl Solution {
    pub fn sort_string(s: String) -> String {
        
        let mut s = s;
        let mut v = vec![0; 26];
        let mut r = String::new();
        for c in s.chars() {
            v[c as usize - 'a' as usize] += 1;
        }
        while r.len() < s.len() {
            for i in 0..26 {
                if v[i] > 0 {
                    r.push((i + 'a' as usize) as u8 as char);
                    v[i] -= 1;
                }
            }
            for i in (0..26).rev() {
                if v[i] > 0 {
                    r.push((i + 'a' as usize) as u8 as char);
                    v[i] -= 1;
                }
            }
        }
        r
    }
}