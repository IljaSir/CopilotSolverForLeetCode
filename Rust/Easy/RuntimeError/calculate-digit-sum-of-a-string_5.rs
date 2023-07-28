impl Solution {
    pub fn digit_sum(s: String, k: i32) -> String {
        
        let mut s = s;
        let mut k = k as usize;
        while s.len() > k {
            let mut new_s = String::new();
            for i in (0..s.len()).step_by(k) {
                let mut sum = 0;
                for c in s[i..i+k].chars() {
                    sum += c.to_digit(10).unwrap();
                }
                new_s.push_str(&sum.to_string());
            }
            s = new_s;
        }
        s
    }
}