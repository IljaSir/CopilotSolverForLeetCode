impl Solution {
    pub fn num_unique_emails(emails: Vec<String>) -> i32 {
        
        let mut result = std::collections::HashSet::new();
        for email in emails {
            let email: Vec<_> = email.split('@').collect();
            let local_name = email[0].replace(".", "");
            let local_name: Vec<_> = local_name.split('+').collect();
            let local_name = local_name[0];
            let domain_name = email[1];
            let address = format!("{}@{}", local_name, domain_name);
            result.insert(address);
        }
        result.len() as i32
    }
}