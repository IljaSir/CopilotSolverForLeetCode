impl Solution {
    pub fn valid_ip_address(query_ip: String) -> String {
        

        let mut is_ipv4 = true;
        let mut is_ipv6 = true;
        let mut count = 0;
        if query_ip.contains('.') {
            let v:Vec<&str> = query_ip.split('.').collect();
            if v.len() != 4 {
                return "Neither".to_string();
            }
            for i in v {
                count += 1;
                if i.len() > 3 || i.len() == 0 || i.len() > 1 && i.starts_with('0') {
                    is_ipv4 = false;
                    break;
                }
                let mut num = 0;
                for j in i.chars() {
                    if !j.is_digit(10) {
                        is_ipv4 = false;
                        break;
                    }
                    num = num * 10 + j.to_digit(10).unwrap();
                }
                if num > 255 {
                    is_ipv4 = false;
                    break;
                }
            }
            if count == 4 {
                if is_ipv4 {
                    return "IPv4".to_string();
                } else {
                    return "Neither".to_string();
                }
            }
        } else if query_ip.contains(':') {
            let v:Vec<&str> = query_ip.split(':').collect();
            if v.len() != 8 {
                return "Neither".to_string();
            }
            for i in v {
                count += 1;
                if i.len() > 4 || i.len() == 0 {
                    is_ipv6 = false;
                    break;
                }
                for j in i.chars() {
                    if !j.is_digit(16) && !j.is_ascii_alphabetic() {
                        is_ipv6 = false;
                        break;
                    }
                }
            }
            if count == 8 {
                if is_ipv6 {
                    return "IPv6".to_string();
                } else {
                    return "Neither".to_string();
                }
            }
        }
        return "Neither".to_string();
    }
}