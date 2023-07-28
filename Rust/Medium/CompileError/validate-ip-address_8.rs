impl Solution {
    pub fn valid_ip_address(query_ip: String) -> String {
        

        if query_ip.chars().filter(|c| *c == '.').count() == 3 {
            if query_ip.split(".").map(|s| s.parse::<u8>()).all(|x| x.is_ok() && x.unwrap() < 256 && (x.unwrap() > 0 || s.len() == 1)) {
                return "IPv4".to_string();
            }
        }
        if query_ip.chars().filter(|c| *c == ':').count() == 7 {
            if query_ip.split(":").map(|s| u16::from_str_radix(s, 16)).all(|x| x.is_ok() && (x.unwrap() > 0 || s.len() == 1)) {
                return "IPv6".to_string();
            }
        }
        "Neither".to_string()
    }
}