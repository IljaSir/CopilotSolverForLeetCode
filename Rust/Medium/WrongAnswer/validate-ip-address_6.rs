impl Solution {
    pub fn valid_ip_address(query_ip: String) -> String {
        

        if query_ip.contains(".") {
            if query_ip.split(".").count() != 4 {
                return String::from("Neither");
            }
            for i in query_ip.split(".") {
                if i.len() > 1 && i.chars().nth(0).unwrap() == '0' {
                    return String::from("Neither");
                }
                if i.len() > 3 {
                    return String::from("Neither");
                }
                match i.parse::<i32>() {
                    Ok(n) => {
                        if n < 0 || n > 255 {
                            return String::from("Neither");
                        }
                    },
                    Err(_) => return String::from("Neither"),
                }
            }
            return String::from("IPv4");
        } else if query_ip.contains(":") {
            if query_ip.split(":").count() != 8 {
                return String::from("Neither");
            }
            for i in query_ip.split(":") {
                if i.len() > 4 {
                    return String::from("Neither");
                }
                for j in i.chars() {
                    if !j.is_digit(16) {
                        return String::from("Neither");
                    }
                }
            }
            return String::from("IPv6");
        } else {
            return String::from("Neither");
        }
    }
}