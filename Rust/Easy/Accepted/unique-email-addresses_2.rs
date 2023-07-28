impl Solution {
    pub fn num_unique_emails(emails: Vec<String>) -> i32 {
        
        let mut set = std::collections::HashSet::new();
        for email in emails {
            let mut parts = email.split('@');
            let local = parts.next().unwrap();
            let domain = parts.next().unwrap();
            let mut local = local.replace(".", "");
            if let Some(idx) = local.find('+') {
                local = local[..idx].to_string();
            }
            set.insert(format!("{}@{}", local, domain));
        }
        set.len() as i32
    }
}