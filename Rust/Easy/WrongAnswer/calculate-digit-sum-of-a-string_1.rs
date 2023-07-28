impl Solution {
    pub fn digit_sum(s: String, k: i32) -> String {
        
        let mut s = s;
        let k = k as usize;
        while s.len() > k {
            let mut t = String::new();
            let mut i = 0;
            while i < s.len() {
                let mut sum = 0;
                for j in 0..k {
                    if i + j < s.len() {
                        sum += s.chars().nth(i + j).unwrap() as i32 - 48;
                    }
                }
                t.push((sum % 10 + 48) as u8 as char);
                i += k;
            }
            s = t;
        }
        s
    }
}