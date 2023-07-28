impl Solution {
    pub fn full_justify(words: Vec<String>, max_width: i32) -> Vec<String> {
        
        let mut lines = Vec::new();
        let mut line = Vec::new();
        let mut line_len = 0;
        for word in words {
            let word_len = word.len();
            if line_len + word_len + line.len() <= max_width as usize {
                line.push(word);
                line_len += word_len;
            } else {
                lines.push(line);
                line = vec![word];
                line_len = word_len;
            }
        }
        lines.push(line);
        let mut result = Vec::new();
        for i in 0..lines.len() - 1 {
            let mut line = lines[i].join(" ");
            let mut spaces = max_width - line.len() as i32;
            if lines[i].len() > 1 {
                let mut j = 0;
                while spaces > 0 {
                    if line[j..].starts_with(" ") {
                        line.insert(j, ' ');
                        spaces -= 1;
                    }
                    j += 1;
                }
            } else {
                line.push_str(&" ".repeat(spaces as usize));
            }
            result.push(line);
        }
        let mut line = lines[lines.len() - 1].join(" ");
        line.push_str(&" ".repeat((max_width - line.len() as i32) as usize));
        result.push(line);
        result
    }
}