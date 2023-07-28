impl Solution {
    pub fn entity_parser(text: String) -> String {
        
        let mut res: String = String::new();
        let mut i = 0;
        while i < text.len() {
            if text.as_bytes()[i] == b'&' {
                if i + 6 < text.len() && &text[i..i+6] == "&quot;" {
                    res.push('"');
                    i += 6;
                } else if i + 6 < text.len() && &text[i..i+6] == "&apos;" {
                    res.push('\'');
                    i += 6;
                } else if i + 5 < text.len() && &text[i..i+5] == "&amp;" {
                    res.push('&');
                    i += 5;
                } else if i + 4 < text.len() && &text[i..i+4] == "&gt;" {
                    res.push('>');
                    i += 4;
                } else if i + 4 < text.len() && &text[i..i+4] == "&lt;" {
                    res.push('<');
                    i += 4;
                } else if i + 7 < text.len() && &text[i..i+7] == "&frasl;" {
                    res.push('/');
                    i += 7;
                } else {
                    res.push(text.as_bytes()[i] as char);
                    i += 1;
                }
            } else {
                res.push(text.as_bytes()[i] as char);
                i += 1;
            }
        }
        res
    }
}