impl Solution {
    pub fn modify_string(s: String) -> String {
        
        let mut s = s;
        let mut prev = b' ';
        let mut next = b' ';
        for i in 0..s.len() {
            if s.as_bytes()[i] == b'?' {
                if i == s.len() - 1 {
                    next = b' ';
                } else {
                    next = s.as_bytes()[i + 1];
                }
                let mut c = b'a';
                while c == prev || c == next {
                    c += 1;
                }
                s.as_bytes_mut()[i] = c;
                prev = c;
            } else {
                prev = s.as_bytes()[i];
            }
        }
        s
    }
}