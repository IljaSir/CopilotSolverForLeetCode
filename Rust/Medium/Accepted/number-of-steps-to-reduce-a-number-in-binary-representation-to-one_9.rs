impl Solution {
    pub fn num_steps(s: String) -> i32 {
        
        let mut s = s;
        let mut steps = 0;
        while s.len() > 1 {
            if s.ends_with('1') {
                let mut carry = true;
                let mut chars = s.chars().rev();
                let mut new_s = String::new();
                while let Some(c) = chars.next() {
                    if carry {
                        if c == '1' {
                            new_s.push('0');
                        } else {
                            new_s.push('1');
                            carry = false;
                        }
                    } else {
                        new_s.push(c);
                    }
                }
                if carry {
                    new_s.push('1');
                }
                s = new_s.chars().rev().collect();
            } else {
                s.pop();
            }
            steps += 1;
        }
        steps
    }
}