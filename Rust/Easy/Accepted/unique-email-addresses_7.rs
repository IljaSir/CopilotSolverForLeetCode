impl Solution {
    pub fn num_unique_emails(emails: Vec<String>) -> i32 {
        
        let mut result = 0;
        let mut set = std::collections::HashSet::new();
        for email in emails {
            let mut parts = email.split("@");
            let mut local_name = parts.next().unwrap().to_string();
            let domain_name = parts.next().unwrap().to_string();
            local_name = local_name.replace(".", "");
            local_name = local_name.split("+").next().unwrap().to_string();
            let mut email = local_name;
            email.push('@');
            email.push_str(&domain_name);
            if set.insert(email) {
                result += 1;
            }
        }
        result
    }
}