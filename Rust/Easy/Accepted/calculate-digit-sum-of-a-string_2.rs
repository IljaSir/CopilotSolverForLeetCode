impl Solution {
    pub fn digit_sum(s: String, k: i32) -> String {
        
        let mut s = s;
        let k = k as usize;
        while s.len() > k {
            let mut new_s = String::new();
            let mut i = 0;
            while i < s.len() {
                let mut sum = 0;
                for c in s[i..(i+k).min(s.len())].chars() {
                    sum += c.to_digit(10).unwrap();
                }
                new_s.push_str(&sum.to_string());
                i += k;
            }
            s = new_s;
        }
        s
    }
}