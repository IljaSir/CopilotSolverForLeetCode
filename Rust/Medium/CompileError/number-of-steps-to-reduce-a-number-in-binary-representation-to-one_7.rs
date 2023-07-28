impl Solution {
    pub fn num_steps(s: String) -> i32 {
        
        let mut s = s;
        let mut count = 0;
        let mut carry = 0;
        while s.len() > 1 || s != "1" {
            count += 1;
            if s.ends_with("1") {
                s = format!("{:0>1$}", s, s.len() + 1);
                carry = 1;
            } else {
                s.pop();
            }
            if carry == 1 {
                for i in (0..s.len()).rev() {
                    if s.as_bytes()[i] == b'1' {
                        s.as_bytes_mut()[i] = b'0';
                    } else {
                        s.as_bytes_mut()[i] = b'1';
                        carry = 0;
                        break;
                    }
                }
            }
        }
        count
    }
}