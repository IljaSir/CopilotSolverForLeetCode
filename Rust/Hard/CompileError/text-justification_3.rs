impl Solution {
    pub fn full_justify(words: Vec<String>, max_width: i32) -> Vec<String> {
        
        let mut result = vec![];
        let mut line = vec![];
        let mut line_len = 0;
        for word in words {
            let word_len = word.len();
            if line_len + word_len + line.len() > max_width as usize {
                let mut line_str = String::new();
                if line.len() == 1 {
                    line_str.push_str(&line[0]);
                    line_str.push_str(&" ".repeat(max_width as usize - line_len));
                } else {
                    let spaces = (max_width - line_len as i32) as usize;
                    let base = spaces / (line.len() - 1);
                    let extra = spaces % (line.len() - 1);
                    let mut extra_count = 0;
                    for i in 0..line.len() {
                        line_str.push_str(&line[i]);
                        if i < line.len() - 1 {
                            line_str.push_str(&" ".repeat(base));
                            if extra_count < extra {
                                line_str.push(' ');
                                extra_count += 1;
                            }
                        }
                    }
                }
                result.push(line_str);
                line = vec![word];
                line_len = word_len;
            } else {
                line.push(word);
                line_len += word_len;
            }
        }
        if line.len() > 0 {
            let mut line_str = String::new();
            for i in 0..line.len() {
                line_str.push_str(&line[i]);
                if i < line.len() - 1 {
                    line_str.push(' ');
                }
            }
            line_str.push_str(&" ".repeat(max_width as usize - line_str.len()));
            result.push(line_str);
        }
        result
    }
}