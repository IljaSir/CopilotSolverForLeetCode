impl Solution {
    pub fn valid_ip_address(query_ip: String) -> String {
        

        if query_ip.contains(".") {
            if query_ip.split(".").count() != 4 {
                return "Neither".to_string();
            }
            for ip in query_ip.split(".") {
                if ip.len() > 1 && ip.starts_with("0") {
                    return "Neither".to_string();
                }
                if ip.chars().any(|c| !c.is_digit(10)) {
                    return "Neither".to_string();
                }
                if let Ok(n) = ip.parse::<i32>() {
                    if n < 0 || n > 255 {
                        return "Neither".to_string();
                    }
                } else {
                    return "Neither".to_string();
                }
            }
            return "IPv4".to_string();
        } else if query_ip.contains(":") {
            if query_ip.split(":").count() != 8 {
                return "Neither".to_string();
            }
            for ip in query_ip.split(":") {
                if ip.len() > 4 || ip.len() == 0 {
                    return "Neither".to_string();
                }
                if ip.chars().any(|c| !c.is_digit(16)) {
                    return "Neither".to_string();
                }
            }
            return "IPv6".to_string();
        }
        return "Neither".to_string();
    }
}