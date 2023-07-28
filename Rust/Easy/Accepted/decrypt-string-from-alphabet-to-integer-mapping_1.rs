impl Solution {
    pub fn freq_alphabets(s: String) -> String {
        
        let mut res = String::new();
        let mut i = 0;
        while i < s.len() {
            if i + 2 < s.len() && &s[i+2..i+3] == "#" {
                let num = &s[i..i+2];
                let c = ((num.parse::<u8>().unwrap() - 1) + 'a' as u8) as char;
                res.push(c);
                i += 3;
            } else {
                let c = ((s[i..i+1].parse::<u8>().unwrap() - 1) + 'a' as u8) as char;
                res.push(c);
                i += 1;
            }
        }
        res
    }
}