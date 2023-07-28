impl Solution {
    pub fn can_be_valid(s: String, locked: String) -> bool {
        
        let s: Vec<char> = s.chars().collect();
        let locked: Vec<char> = locked.chars().collect();
        let n = s.len();
        let mut stack = Vec::new();
        let mut i = 0;
        while i < n {
            if locked[i] == '0' {
                match s[i] {
                    '(' => stack.push('('),
                    ')' => {
                        if stack.len() > 0 {
                            stack.pop();
                        } else {
                            stack.push(')');
                        }
                    }
                    _ => (),
                }
            }
            i += 1;
        }
        if stack.len() == 0 {
            return true;
        }
        let mut i = 0;
        while i < n {
            if locked[i] == '0' {
                match s[i] {
                    '(' => {
                        if stack.len() > 0 {
                            stack.pop();
                        } else {
                            stack.push('(');
                        }
                    }
                    ')' => stack.push(')'),
                    _ => (),
                }
            }
            i += 1;
        }
        if stack.len() == 0 {
            return true;
        }
        false
    }
}