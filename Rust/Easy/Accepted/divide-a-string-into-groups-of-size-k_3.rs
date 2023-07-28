impl Solution {
    pub fn divide_string(s: String, k: i32, fill: char) -> Vec<String> {
        
        let mut res = Vec::new();
        let mut s = s.chars().collect::<Vec<char>>();
        let mut i = 0;
        while i < s.len() {
            let mut tmp = String::new();
            for j in 0..k {
                if i < s.len() {
                    tmp.push(s[i]);
                    i += 1;
                } else {
                    tmp.push(fill);
                }
            }
            res.push(tmp);
        }
        res
    }
}