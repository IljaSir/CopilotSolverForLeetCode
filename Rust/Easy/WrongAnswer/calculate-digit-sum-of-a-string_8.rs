impl Solution {
    pub fn digit_sum(s: String, k: i32) -> String {
        
        let k = k as usize;
        let mut s = s;
        loop {
            let mut sum = String::new();
            for i in 0..s.len() / k {
                let mut tmp = 0;
                for j in 0..k {
                    tmp += (s.as_bytes()[i * k + j] - b'0') as i32;
                }
                sum.push_str(&tmp.to_string());
            }
            if s.len() % k != 0 {
                let mut tmp = 0;
                for j in 0..s.len() % k {
                    tmp += (s.as_bytes()[s.len() / k * k + j] - b'0') as i32;
                }
                sum.push_str(&tmp.to_string());
            }
            if sum.len() <= k {
                return sum;
            }
            s = sum;
        }
    }
}