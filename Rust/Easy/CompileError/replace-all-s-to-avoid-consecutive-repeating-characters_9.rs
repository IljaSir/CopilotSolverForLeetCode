impl Solution {
    pub fn modify_string(s: String) -> String {
        
        let mut res = s;
        let mut i = 0;
        while i < res.len() {
            if res.as_bytes()[i] == b'?' {
                let mut c = b'a';
                while (i > 0 && res.as_bytes()[i - 1] == c) || (i + 1 < res.len() && res.as_bytes()[i + 1] == c) {
                    c += 1;
                }
                res.as_bytes_mut()[i] = c;
            }
            i += 1;
        }
        res
    }
}