impl Solution {
    pub fn entity_parser(text: String) -> String {
        
        let mut result = String::new();
        let mut i = 0;
        while i < text.len() {
            if text.as_bytes()[i] == b'&' {
                if i + 6 < text.len() && &text[i..i+6] == "&quot;" {
                    result.push('"');
                    i += 6;
                } else if i + 6 < text.len() && &text[i..i+6] == "&apos;" {
                    result.push('\'');
                    i += 6;
                } else if i + 5 < text.len() && &text[i..i+5] == "&amp;" {
                    result.push('&');
                    i += 5;
                } else if i + 4 < text.len() && &text[i..i+4] == "&gt;" {
                    result.push('>');
                    i += 4;
                } else if i + 4 < text.len() && &text[i..i+4] == "&lt;" {
                    result.push('<');
                    i += 4;
                } else if i + 7 < text.len() && &text[i..i+7] == "&frasl;" {
                    result.push('/');
                    i += 7;
                } else {
                    result.push('&');
                    i += 1;
                }
            } else {
                result.push(text.as_bytes()[i] as char);
                i += 1;
            }
        }
        result
    }
}