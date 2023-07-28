impl Solution {
    pub fn num_unique_emails(emails: Vec<String>) -> i32 {
        
        let mut v = Vec::new();
        for i in emails {
            let mut s = String::new();
            let mut flag = false;
            for j in i.chars() {
                if j == '@' {
                    flag = true;
                }
                if j == '+' {
                    flag = true;
                }
                if flag {
                    s.push(j);
                    continue;
                }
                if j == '.' {
                    continue;
                }
                s.push(j);
            }
            v.push(s);
        }
        v.sort();
        v.dedup();
        v.len() as i32
    }
}