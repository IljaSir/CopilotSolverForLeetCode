impl Solution {
    pub fn num_unique_emails(emails: Vec<String>) -> i32 {
        
        let mut set = std::collections::HashSet::new();
        for email in emails {
            let mut s = String::new();
            let mut plus = false;
            let mut at = false;
            for c in email.chars() {
                if c == '@' {
                    at = true;
                }
                if at {
                    s.push(c);
                } else {
                    if c == '+' {
                        plus = true;
                    } else if c == '.' {
                        continue;
                    } else {
                        if plus {
                            continue;
                        } else {
                            s.push(c);
                        }
                    }
                }
            }
            set.insert(s);
        }
        set.len() as i32
    }
}