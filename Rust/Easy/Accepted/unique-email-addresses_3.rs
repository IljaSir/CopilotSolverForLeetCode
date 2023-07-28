impl Solution {
    pub fn num_unique_emails(emails: Vec<String>) -> i32 {
        
        let mut set = std::collections::HashSet::new();
        for email in emails {
            let mut iter = email.split('@');
            let local = iter.next().unwrap();
            let domain = iter.next().unwrap();
            let mut local = local.replace(".", "");
            let plus = local.find('+').unwrap_or(local.len());
            local.truncate(plus);
            set.insert(local + "@" + domain);
        }
        set.len() as i32
    }
}