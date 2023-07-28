impl Solution {
    pub fn freq_alphabets(s: String) -> String {
        
        let mut res = String::new();
        let mut i = 0;
        while i < s.len() {
            if i + 2 < s.len() && &s[i+2..i+3] == "#" {
                res.push((96 + s[i..i+2].parse::<u8>().unwrap()) as char);
                i += 3;
            } else {
                res.push((96 + s[i..i+1].parse::<u8>().unwrap()) as char);
                i += 1;
            }
        }
        res
    }
}