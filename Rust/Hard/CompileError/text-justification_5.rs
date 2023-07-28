impl Solution {
    pub fn full_justify(words: Vec<String>, max_width: i32) -> Vec<String> {
        
        let mut result = vec![];
        let mut line = vec![];
        let mut line_length = 0;
        for word in words {
            let word_length = word.len();
            if line_length + word_length + line.len() > max_width as usize {
                let mut line_string = String::new();
                let mut spaces = max_width as usize - line_length;
                if line.len() == 1 {
                    line_string.push_str(&line[0]);
                    line_string.push_str(&" ".repeat(spaces));
                } else {
                    let spaces_between = spaces / (line.len() - 1);
                    let extra_spaces = spaces % (line.len() - 1);
                    for (i, word) in line.iter().enumerate() {
                        line_string.push_str(word);
                        if i < line.len() - 1 {
                            line_string.push_str(&" ".repeat(spaces_between));
                            if i < extra_spaces {
                                line_string.push(' ');
                            }
                        }
                    }
                }
                result.push(line_string);
                line_length = 0;
                line.clear();
            }
            line.push(word);
            line_length += word_length;
        }
        if !line.is_empty() {
            let mut line_string = String::new();
            for (i, word) in line.iter().enumerate() {
                line_string.push_str(word);
                if i < line.len() - 1 {
                    line_string.push(' ');
                }
            }
            line_string.push_str(&" ".repeat(max_width as usize - line_string.len()));
            result.push(line_string);
        }
        result
    }
}