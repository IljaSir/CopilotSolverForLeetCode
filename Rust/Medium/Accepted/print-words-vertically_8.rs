impl Solution {
    pub fn print_vertically(s: String) -> Vec<String> {
        
        let mut max = 0;
        let mut words = Vec::new();
        let mut ans = Vec::new();
        for w in s.split_whitespace() {
            words.push(w);
            if w.len() > max {
                max = w.len();
            }
        }
        for i in 0..max {
            let mut s = String::new();
            for w in &words {
                if i < w.len() {
                    s.push(w.chars().nth(i).unwrap());
                } else {
                    s.push(' ');
                }
            }
            ans.push(s.trim_end().to_string());
        }
        ans
    }
}