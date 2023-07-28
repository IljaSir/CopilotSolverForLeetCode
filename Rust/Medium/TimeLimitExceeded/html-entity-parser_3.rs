impl Solution {
    pub fn entity_parser(text: String) -> String {
        
        let mut ret = String::new();
        let mut i = 0;
        while i < text.len() {
            if text[i..].starts_with("&quot;") {
                ret.push('"');
                i += 6;
            } else if text[i..].starts_with("&apos;") {
                ret.push('\'');
                i += 6;
            } else if text[i..].starts_with("&amp;") {
                ret.push('&');
                i += 5;
            } else if text[i..].starts_with("&gt;") {
                ret.push('>');
                i += 4;
            } else if text[i..].starts_with("&lt;") {
                ret.push('<');
                i += 4;
            } else if text[i..].starts_with("&frasl;") {
                ret.push('/');
                i += 7;
            } else {
                ret.push(text.chars().nth(i).unwrap());
                i += 1;
            }
        }
        ret
    }
}