impl Solution {
    pub fn can_be_valid(s: String, locked: String) -> bool {
        
        let mut stack = vec![];
        let mut locked = locked.chars().collect::<Vec<_>>();
        for (i, c) in s.chars().enumerate() {
            if c == '(' {
                stack.push(i);
            } else {
                if let Some(&p) = stack.last() {
                    if locked[p] == '0' && locked[i] == '0' {
                        stack.pop();
                    }
                }
            }
        }
        if stack.is_empty() {
            return true;
        }
        if stack.len() % 2 == 1 {
            return false;
        }
        let mut locked = locked.into_iter().enumerate().collect::<Vec<_>>();
        locked.sort_by(|a, b| a.1.cmp(&b.1));
        let mut i = 0;
        while i < stack.len() {
            let p = stack[i];
            let q = stack[i+1];
            if locked[p].1 == '0' && locked[q].1 == '0' {
                i += 2;
            } else {
                return false;
            }
        }
        true
    }
}