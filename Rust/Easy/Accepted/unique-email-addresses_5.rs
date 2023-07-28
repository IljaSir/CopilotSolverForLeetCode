impl Solution {
    pub fn num_unique_emails(emails: Vec<String>) -> i32 {
        
        let mut set = std::collections::HashSet::new();
        for email in emails {
            let mut iter = email.split('@');
            let mut local = iter.next().unwrap().to_string();
            let domain = iter.next().unwrap().to_string();
            local = local.split('+').next().unwrap().to_string();
            local = local.replace(".", "");
            let new_email = local + "@" + &domain;
            set.insert(new_email);
        }
        set.len() as i32
    }
}