impl Solution {
    pub fn can_be_valid(s: String, locked: String) -> bool {
        
        let mut s = s.chars().collect::<Vec<char>>();
        let mut locked = locked.chars().collect::<Vec<char>>();
        let mut stack = Vec::new();
        for i in 0..s.len() {
            if locked[i] == '1' {
                continue;
            }
            if s[i] == '(' {
                stack.push(i);
            } else if s[i] == ')' {
                if let Some(j) = stack.pop() {
                    locked[j] = '1';
                    locked[i] = '1';
                }
            }
        }
        let mut stack = Vec::new();
        for i in (0..s.len()).rev() {
            if locked[i] == '1' {
                continue;
            }
            if s[i] == ')' {
                stack.push(i);
            } else if s[i] == '(' {
                if let Some(j) = stack.pop() {
                    locked[j] = '1';
                    locked[i] = '1';
                }
            }
        }
        let mut count = 0;
        for i in 0..s.len() {
            if locked[i] == '1' {
                continue;
            }
            if s[i] == '(' {
                count += 1;
            } else if s[i] == ')' {
                count -= 1;
            }
        }
        count == 0
    }
}