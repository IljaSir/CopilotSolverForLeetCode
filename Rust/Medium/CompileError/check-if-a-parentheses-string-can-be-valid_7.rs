impl Solution {
    pub fn can_be_valid(s: String, locked: String) -> bool {
        
        let mut stack = Vec::new();
        let mut locked = locked.into_bytes();
        let mut s = s.into_bytes();
        for i in 0..s.len() {
            if locked[i] == b'1' {
                continue;
            }
            if s[i] == b'(' {
                stack.push(i);
            } else {
                if let Some(j) = stack.pop() {
                    locked[j] = b'1';
                    locked[i] = b'1';
                }
            }
        }
        let mut stack = Vec::new();
        let mut s = s.into_bytes();
        for i in 0..s.len() {
            if locked[i] == b'1' {
                continue;
            }
            if s[i] == b'(' {
                stack.push(i);
            } else {
                if let Some(j) = stack.pop() {
                    locked[j] = b'1';
                    locked[i] = b'1';
                }
            }
        }
        locked.iter().all(|&x| x == b'1')
    }
}