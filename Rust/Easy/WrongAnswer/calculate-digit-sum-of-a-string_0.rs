impl Solution {
    pub fn digit_sum(s: String, k: i32) -> String {
        
        let mut s = s;
        let k = k as usize;
        while s.len() > k {
            let mut t = String::new();
            let mut i = 0;
            while i < s.len() {
                let mut sum = 0;
                let end = std::cmp::min(i + k, s.len());
                for c in s[i..end].chars() {
                    sum += c as i32 - '0' as i32;
                }
                t.push((sum % 10 + '0' as i32) as u8 as char);
                i += k;
            }
            s = t;
        }
        s
    }
}