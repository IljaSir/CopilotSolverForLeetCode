impl Solution {
    pub fn valid_ip_address(query_ip: String) -> String {
        

        if query_ip.contains('.') {
            if query_ip.split('.').count() != 4 {
                return "Neither".to_string();
            }
            for i in query_ip.split('.') {
                if i.len() == 0 || i.len() > 3 {
                    return "Neither".to_string();
                }
                if i.len() > 1 && i.chars().nth(0).unwrap() == '0' {
                    return "Neither".to_string();
                }
                let mut num = 0;
                for j in i.chars() {
                    if !j.is_digit(10) {
                        return "Neither".to_string();
                    }
                    num = num * 10 + j.to_digit(10).unwrap();
                }
                if num > 255 {
                    return "Neither".to_string();
                }
            }
            return "IPv4".to_string();
        } else if query_ip.contains(':') {
            if query_ip.split(':').count() != 8 {
                return "Neither".to_string();
            }
            for i in query_ip.split(':') {
                if i.len() == 0 || i.len() > 4 {
                    return "Neither".to_string();
                }
                for j in i.chars() {
                    if !j.is_digit(16) {
                        return "Neither".to_string();
                    }
                }
            }
            return "IPv6".to_string();
        } else {
            return "Neither".to_string();
        }
    }
}