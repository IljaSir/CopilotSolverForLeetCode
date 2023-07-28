impl Solution {
    pub fn digit_sum(s: String, k: i32) -> String {
        
        let mut s = s;
        let k = k as usize;
        while s.len() > k {
            let mut t = String::new();
            for i in 0..(s.len() / k) {
                let mut sum = 0;
                for j in 0..k {
                    sum += s.chars().nth(i * k + j).unwrap() as i32 - '0' as i32;
                }
                t.push_str(&sum.to_string());
            }
            s = t;
        }
        s
    }
}