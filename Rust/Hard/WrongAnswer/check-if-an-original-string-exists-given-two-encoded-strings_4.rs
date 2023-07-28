impl Solution {
    pub fn possibly_equals(s1: String, s2: String) -> bool {
        
        Self::decode(s1) == Self::decode(s2)
    }
    
    fn decode(s: String) -> String {
        let mut res = String::new();
        let mut i = 0;
        while i < s.len() {
            let mut j = i;
            while j < s.len() && s.as_bytes()[j] >= b'0' && s.as_bytes()[j] <= b'9' {
                j += 1;
            }
            if j == i {
                res.push(s.as_bytes()[i] as char);
                i += 1;
            } else {
                let len = s[i..j].parse::<usize>().unwrap();
                i = j + len;
            }
        }
        res
    }
}