impl Solution {
    pub fn num_steps(s: String) -> i32 {
        
        let mut c = 0;
        let mut s = s;
        while s != "1" {
            if s.ends_with("0") {
                s.pop();
            } else {
                let mut i = s.len() - 1;
                while i > 0 && s.as_bytes()[i] == b'1' {
                    s.replace_range(i..=i, "0");
                    i -= 1;
                }
                if i == 0 && s.as_bytes()[i] == b'1' {
                    s.replace_range(i..=i, "0");
                    s.insert(0, '1');
                } else {
                    s.replace_range(i..=i, "1");
                }
            }
            c += 1;
        }
        c
    }
}