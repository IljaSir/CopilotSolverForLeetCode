impl Solution {
    pub fn num_steps(s: String) -> i32 {
        
        let mut step = 0;
        let mut s = s;
        while s != "1" {
            let l = s.len();
            if s.as_bytes()[l-1] == b'0' {
                s = s[..l-1].to_string();
            } else {
                let mut i = l - 1;
                let mut c = 0;
                while i >= 0 && s.as_bytes()[i] == b'1' {
                    c += 1;
                    i -= 1;
                }
                s = s[..i+1].to_string();
                for _ in 0..c+1 {
                    s.push('0');
                }
            }
            step += 1;
        }
        step
    }
}