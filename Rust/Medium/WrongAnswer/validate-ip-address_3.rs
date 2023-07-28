impl Solution {
    pub fn valid_ip_address(query_ip: String) -> String {
        

        let ipv4 = query_ip.split('.').collect::<Vec<&str>>();
        let ipv6 = query_ip.split(':').collect::<Vec<&str>>();
        if ipv4.len() == 4 {
            for i in &ipv4 {
                if i.len() > 1 && i.starts_with('0') {
                    return "Neither".to_string();
                }
                if let Ok(n) = i.parse::<u8>() {
                    if n > 255 {
                        return "Neither".to_string();
                    }
                } else {
                    return "Neither".to_string();
                }
            }
            return "IPv4".to_string();
        } else if ipv6.len() == 8 {
            for i in &ipv6 {
                if i.len() > 4 {
                    return "Neither".to_string();
                }
                if let Ok(_) = i.parse::<u16>() {
                } else {
                    return "Neither".to_string();
                }
            }
            return "IPv6".to_string();
        }
        return "Neither".to_string();
    }
}