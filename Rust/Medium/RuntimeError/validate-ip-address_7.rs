impl Solution {
    pub fn valid_ip_address(query_ip: String) -> String {
        

        if query_ip.contains('.') {
            let mut valid = true;
            let mut octets = query_ip.split('.');
            if octets.clone().count() != 4 {
                valid = false;
            }
            for octet in octets {
                if octet.len() == 0 || octet.len() > 3 {
                    valid = false;
                }
                if octet.starts_with('0') && octet.len() > 1 {
                    valid = false;
                }
                for c in octet.chars() {
                    if !c.is_digit(10) {
                        valid = false;
                    }
                }
                if octet.parse::<i32>().unwrap() > 255 {
                    valid = false;
                }
            }
            if valid {
                return "IPv4".to_string();
            }
        } else if query_ip.contains(':') {
            let mut valid = true;
            let mut octets = query_ip.split(':');
            if octets.clone().count() != 8 {
                valid = false;
            }
            for octet in octets {
                if octet.len() == 0 || octet.len() > 4 {
                    valid = false;
                }
                for c in octet.chars() {
                    if !c.is_digit(16) {
                        valid = false;
                    }
                }
            }
            if valid {
                return "IPv6".to_string();
            }
        }
        return "Neither".to_string();
    }
}