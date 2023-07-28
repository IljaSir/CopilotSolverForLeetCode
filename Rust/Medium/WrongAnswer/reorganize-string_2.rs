impl Solution {
    pub fn reorganize_string(s: String) -> String {
        
        let mut s: Vec<char> = s.chars().collect();
        s.sort();
        let mut i = 0;
        while i < s.len() - 1 {
            if s[i] == s[i + 1] {
                return "".to_string();
            }
            i += 2;
        }
        let mut res = String::new();
        let mut j = 1;
        for i in (0..s.len()).step_by(2) {
            res.push(s[i]);
            if j < s.len() {
                res.push(s[j]);
                j += 2;
            }
        }
        res
    }
}