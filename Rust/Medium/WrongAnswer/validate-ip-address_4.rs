impl Solution {
    pub fn valid_ip_address(query_ip: String) -> String {
        

        if query_ip.contains(".") {
            let v: Vec<&str> = query_ip.split(".").collect();
            if v.len() != 4 { return "Neither".to_string(); }
            for x in v {
                if x.len() == 0 || x.len() > 3 { return "Neither".to_string(); }
                if x.len() > 1 && x.starts_with("0") { return "Neither".to_string(); }
                if x.parse::<i32>().unwrap() > 255 { return "Neither".to_string(); }
            }
            return "IPv4".to_string();
        }
        if query_ip.contains(":") {
            let v: Vec<&str> = query_ip.split(":").collect();
            if v.len() != 8 { return "Neither".to_string(); }
            for x in v {
                if x.len() == 0 || x.len() > 4 { return "Neither".to_string(); }
                if x.parse::<i32>().is_err() { return "Neither".to_string(); }
            }
            return "IPv6".to_string();
        }
        return "Neither".to_string();
    }
}