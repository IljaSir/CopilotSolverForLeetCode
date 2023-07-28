impl Solution {
    pub fn can_be_valid(s: String, locked: String) -> bool {
        
        let mut s = s.chars().collect::<Vec<char>>();
        let mut locked = locked.chars().collect::<Vec<char>>();
        let mut stack = vec![];
        for i in 0..s.len() {
            if locked[i] == '0' {
                if s[i] == '(' {
                    stack.push(i);
                } else {
                    if let Some(j) = stack.pop() {
                        locked[j] = '1';
                        locked[i] = '1';
                    }
                }
            }
        }
        let mut stack = vec![];
        for i in (0..s.len()).rev() {
            if locked[i] == '0' {
                if s[i] == ')' {
                    stack.push(i);
                } else {
                    if let Some(j) = stack.pop() {
                        locked[j] = '1';
                        locked[i] = '1';
                    }
                }
            }
        }
        for i in 0..s.len() {
            if locked[i] == '0' {
                if s[i] == '(' {
                    stack.push(i);
                } else {
                    if let Some(j) = stack.pop() {
                        locked[j] = '1';
                        locked[i] = '1';
                    }
                }
            }
        }
        for i in 0..s.len() {
            if locked[i] == '0' {
                if stack.is_empty() {
                    return false;
                }
                let j = stack.pop().unwrap();
                if s[i] == '(' {
                    s[i] = ')';
                    s[j] = '(';
                } else {
                    s[i] = '(';
                    s[j] = ')';
                }
            }
        }
        stack = vec![];
        for i in 0..s.len() {
            if s[i] == '(' {
                stack.push(i);
            } else {
                if let Some(j) = stack.pop() {
                    locked[j] = '1';
                    locked[i] = '1';
                }
            }
        }
        for i in 0..s.len() {
            if locked[i] == '0' {
                return false;
            }
        }
        true
    }
}