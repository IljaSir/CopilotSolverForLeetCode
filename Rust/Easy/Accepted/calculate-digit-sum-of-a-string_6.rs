impl Solution {
    pub fn digit_sum(s: String, k: i32) -> String {
        
        let mut s = s;
        let k = k as usize;
        let mut new_s = String::new();
        while s.len() > k {
            for i in 0..s.len() / k {
                let mut sum = 0;
                for j in 0..k {
                    sum += (s.as_bytes()[i * k + j] - '0' as u8) as i32;
                }
                new_s.push_str(&sum.to_string());
            }
            if s.len() % k != 0 {
                let mut sum = 0;
                for j in 0..s.len() % k {
                    sum += (s.as_bytes()[s.len() / k * k + j] - '0' as u8) as i32;
                }
                new_s.push_str(&sum.to_string());
            }
            s = new_s;
            new_s = String::new();
        }
        s
    }
}