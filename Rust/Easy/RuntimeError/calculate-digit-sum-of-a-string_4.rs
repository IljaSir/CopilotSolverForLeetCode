impl Solution {
    pub fn digit_sum(s: String, k: i32) -> String {
        
        let mut s = s;
        let k = k as usize;
        while s.len() > k {
            let mut tmp = String::new();
            for i in (0..s.len()).step_by(k) {
                tmp.push_str(&s[i..i+k].chars().map(|c| c as i32 - 48).sum::<i32>().to_string());
            }
            s = tmp;
        }
        s
    }
}