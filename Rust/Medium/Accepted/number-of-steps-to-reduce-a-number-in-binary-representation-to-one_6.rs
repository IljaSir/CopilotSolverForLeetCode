impl Solution {
    pub fn num_steps(s: String) -> i32 {
        
        let mut s = s.into_bytes();
        let mut res = 0;
        while s.len() > 1 {
            let last = s.pop().unwrap();
            if last == b'1' {
                res += 1;
                let mut i = s.len();
                while i > 0 && s[i - 1] == b'1' {
                    s[i - 1] = b'0';
                    i -= 1;
                }
                if i == 0 {
                    s.insert(0, b'1');
                } else {
                    s[i - 1] = b'1';
                }
            }
            res += 1;
        }
        res
    }
}