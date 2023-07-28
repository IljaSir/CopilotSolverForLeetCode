impl Solution {
    pub fn longest_common_prefix(strs: Vec<String>) -> String {
        
        let mut result = String::new();
        let mut i = 0;
        let mut flag = true;
        while flag {
            let mut c = ' ';
            for s in strs.iter() {
                let bytes = s.as_bytes();
                if i < bytes.len() {
                    if c == ' ' {
                        c = bytes[i] as char;
                    } else {
                        if c != bytes[i] as char {
                            flag = false;
                            break;
                        }
                    }
                } else {
                    flag = false;
                    break;
                }
            }
            if flag {
                result.push(c);
            }
            i += 1;
        }
        result
    }
}