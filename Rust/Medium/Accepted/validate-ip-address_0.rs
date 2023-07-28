impl Solution {
    pub fn valid_ip_address(query_ip: String) -> String {
        

        if query_ip.contains('.') {
            if query_ip.split('.').count() != 4 {
                return "Neither".to_string();
            }
            for s in query_ip.split('.') {
                if s.len() == 0 || s.len() > 3 {
                    return "Neither".to_string();
                }
                if s.chars().nth(0).unwrap() == '0' && s.len() > 1 {
                    return "Neither".to_string();
                }
                let num = s.parse::<u32>();
                if num.is_err() {
                    return "Neither".to_string();
                }
                let num = num.unwrap();
                if num > 255 {
                    return "Neither".to_string();
                }
            }
            return "IPv4".to_string();
        }
        if query_ip.contains(':') {
            if query_ip.split(':').count() != 8 {
                return "Neither".to_string();
            }
            for s in query_ip.split(':') {
                if s.len() == 0 || s.len() > 4 {
                    return "Neither".to_string();
                }
                let num = u32::from_str_radix(s, 16);
                if num.is_err() {
                    return "Neither".to_string();
                }
            }
            return "IPv6".to_string();
        }
        "Neither".to_string()
    }
}