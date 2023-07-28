impl Solution {
    pub fn mask_pii(s: String) -> String {
        
        if s.contains('@') {
            let mut parts: Vec<&str> = s.split('@').collect();
            let name = parts[0].to_lowercase();
            let domain = parts[1].to_lowercase();
            let first = name.chars().next().unwrap();
            let last = name.chars().last().unwrap();
            return format!("{}*****{}@{}", first, last, domain);
        } else {
            let mut digits: Vec<char> = s.chars().filter(|c| c.is_digit(10)).collect();
            let mut country_code = digits.len() - 10;
            let mut local_number = digits.split_off(country_code);
            let mut masked = String::new();
            if country_code > 0 {
                masked.push('+');
                for _ in 0..country_code {
                    masked.push('*');
                }
                masked.push('-');
            }
            masked.push_str("***-***-");
            masked.push_str(&local_number.iter().collect::<String>());
            return masked;
        }
    }
}