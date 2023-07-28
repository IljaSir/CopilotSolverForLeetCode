impl Solution {
    pub fn can_be_valid(s: String, locked: String) -> bool {
        
        let mut s = s.into_bytes();
        let locked = locked.into_bytes();
        let n = s.len();
        let mut stack = Vec::new();
        for i in 0..n {
            if locked[i] == b'0' {
                if s[i] == b'(' {
                    stack.push(i);
                } else {
                    if let Some(&j) = stack.last() {
                        if s[j] == b'(' {
                            stack.pop();
                        } else {
                            stack.push(i);
                        }
                    } else {
                        stack.push(i);
                    }
                }
            }
        }
        let mut cnt = 0;
        for &i in stack.iter() {
            if s[i] == b'(' {
                cnt += 1;
            } else {
                cnt -= 1;
            }
        }
        cnt == 0
    }
}