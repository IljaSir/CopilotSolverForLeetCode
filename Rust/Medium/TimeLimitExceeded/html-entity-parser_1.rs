impl Solution {
    pub fn entity_parser(text: String) -> String {
        
        let mut res = String::new();
        let mut i = 0;
        while i < text.len() {
            if text[i..].starts_with("&quot;") {
                res.push('"');
                i += 6;
            } else if text[i..].starts_with("&apos;") {
                res.push('\'');
                i += 6;
            } else if text[i..].starts_with("&amp;") {
                res.push('&');
                i += 5;
            } else if text[i..].starts_with("&gt;") {
                res.push('>');
                i += 4;
            } else if text[i..].starts_with("&lt;") {
                res.push('<');
                i += 4;
            } else if text[i..].starts_with("&frasl;") {
                res.push('/');
                i += 7;
            } else {
                res.push(text.chars().nth(i).unwrap());
                i += 1;
            }
        }
        res
    }
}