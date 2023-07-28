impl Solution {
    pub fn remove_comments(source: Vec<String>) -> Vec<String> {
        

        let mut res = Vec::new();
        let mut comment = false;
        let mut line = String::new();
        for s in source {
            let mut i = 0;
            while i < s.len() {
                if !comment {
                    if i + 1 < s.len() && &s[i..i+2] == "/*" {
                        comment = true;
                        i += 1;
                    } else if i + 1 < s.len() && &s[i..i+2] == "//" {
                        break;
                    } else {
                        line.push(s.chars().nth(i).unwrap());
                    }
                } else {
                    if i + 1 < s.len() && &s[i..i+2] == "*/" {
                        comment = false;
                        i += 1;
                    }
                }
                i += 1;
            }
            if !comment && !line.is_empty() {
                res.push(line);
                line = String::new();
            }
        }
        res
    }
}