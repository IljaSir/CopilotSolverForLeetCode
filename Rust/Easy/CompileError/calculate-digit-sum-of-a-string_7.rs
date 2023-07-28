impl Solution {
    pub fn digit_sum(s: String, k: i32) -> String {
        
        let mut s = s;
        let k = k as usize;
        let mut s1 = String::new();
        while s.len() > k {
            s1.clear();
            for i in 0..s.len() / k {
                let mut sum = 0;
                for j in 0..k {
                    sum += s[i * k + j..i * k + j + 1].parse::<i32>().unwrap();
                }
                s1.push_str(&format!("{}", sum));
            }
            if s.len() % k > 0 {
                let mut sum = 0;
                for j in 0..s.len() % k {
                    sum += s[s.len() / k * k + j..s.len() / k * k + j + 1].parse::<i32>().unwrap();
                }
                s1.push_str(&format!("{}", sum));
            }
            s = s1;
        }
        s
    }
}