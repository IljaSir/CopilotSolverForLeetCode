impl Solution {
    pub fn full_justify(words: Vec<String>, max_width: i32) -> Vec<String> {
        
        let max_width = max_width as usize;
        let mut result = vec![];
        let mut line = vec![];
        let mut line_len = 0;
        for word in words {
            let word_len = word.len();
            if line_len + word_len + line.len() > max_width {
                result.push(Solution::justify(line, line_len, max_width));
                line = vec![];
                line_len = 0;
            }
            line.push(word);
            line_len += word_len;
        }
        if !line.is_empty() {
            result.push(Solution::justify_last(line, line_len, max_width));
        }
        result
    }
    fn justify(line: Vec<String>, line_len: usize, max_width: usize) -> String {
        let mut result = String::new();
        let mut spaces = max_width - line_len;
        if line.len() > 1 {
            let mut spaces_per_word = spaces / (line.len() - 1);
            let mut extra_spaces = spaces % (line.len() - 1);
            for word in line {
                result.push_str(&word);
                if spaces > 0 {
                    let mut count = spaces_per_word;
                    if extra_spaces > 0 {
                        count += 1;
                        extra_spaces -= 1;
                    }
                    for _ in 0..count {
                        result.push(' ');
                        spaces -= 1;
                    }
                }
            }
        } else {
            result.push_str(&line[0]);
            for _ in 0..spaces {
                result.push(' ');
            }
        }
        result
    }
    fn justify_last(line: Vec<String>, line_len: usize, max_width: usize) -> String {
        let mut result = String::new();
        let mut spaces = max_width - line_len;
        for word in line {
            result.push_str(&word);
            if spaces > 0 {
                result.push(' ');
                spaces -= 1;
            }
        }
        for _ in 0..spaces {
            result.push(' ');
        }
        result
    }
}