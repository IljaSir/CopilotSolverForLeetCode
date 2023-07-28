impl Solution {
    pub fn full_justify(words: Vec<String>, max_width: i32) -> Vec<String> {
        
        let mut lines = Vec::new();
        let mut line = Vec::new();
        let mut line_width = 0;
        let mut word_width = 0;
        for word in words {
            word_width = word.len();
            if line_width + word_width + line.len() <= max_width as usize {
                line_width += word_width;
                line.push(word);
            } else {
                lines.push(line);
                line = vec![word];
                line_width = word_width;
            }
        }
        if line.len() > 0 {
            lines.push(line);
        }
        let mut result = Vec::new();
        for line in lines {
            let mut line_width = 0;
            for word in line.iter() {
                line_width += word.len();
            }
            let mut line_str = String::new();
            let mut space_count = max_width as usize - line_width;
            let mut space_between = 0;
            let mut space_left = 0;
            if line.len() > 1 {
                space_between = space_count / (line.len() - 1);
                space_left = space_count % (line.len() - 1);
            }
            for i in 0..line.len() {
                line_str.push_str(&line[i]);
                if i < line.len() - 1 {
                    for _ in 0..space_between {
                        line_str.push(' ');
                    }
                    if space_left > 0 {
                        line_str.push(' ');
                        space_left -= 1;
                    }
                } else {
                    for _ in 0..space_count {
                        line_str.push(' ');
                    }
                }
            }
            result.push(line_str);
        }
        result
    }
}