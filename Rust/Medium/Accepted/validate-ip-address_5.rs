impl Solution {
    pub fn valid_ip_address(query_ip: String) -> String {
        

        if query_ip.contains('.') {
            if query_ip.split('.').count() != 4 {
                return "Neither".to_string();
            }
            for part in query_ip.split('.') {
                if part.len() > 3 || part.len() == 0 {
                    return "Neither".to_string();
                }
                for c in part.chars() {
                    if !c.is_digit(10) {
                        return "Neither".to_string();
                    }
                }
                if part.len() > 1 && part.starts_with('0') {
                    return "Neither".to_string();
                }
                if part.parse::<i32>().unwrap() > 255 {
                    return "Neither".to_string();
                }
            }
            return "IPv4".to_string();
        } else if query_ip.contains(':') {
            if query_ip.split(':').count() != 8 {
                return "Neither".to_string();
            }
            for part in query_ip.split(':') {
                if part.len() > 4 || part.len() == 0 {
                    return "Neither".to_string();
                }
                for c in part.chars() {
                    if !c.is_digit(16) {
                        return "Neither".to_string();
                    }
                }
            }
            return "IPv6".to_string();
        }
        return "Neither".to_string();
    }
}