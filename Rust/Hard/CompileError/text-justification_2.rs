impl Solution {
    pub fn full_justify(words: Vec<String>, max_width: i32) -> Vec<String> {
        
        let mut result = Vec::new();
        let mut line = Vec::new();
        let mut line_width = 0;
        for word in words {
            if line_width + line.len() + word.len() > max_width as usize {
                result.push(Self::format_line(line, line_width, max_width));
                line = Vec::new();
                line_width = 0;
            }
            line.push(word);
            line_width += word.len();
        }
        if !line.is_empty() {
            result.push(Self::format_last_line(line, max_width));
        }
        result
    }
    fn format_line(line: Vec<String>, line_width: usize, max_width: i32) -> String {
        let spaces = max_width as usize - line_width;
        let mut result = String::new();
        if line.len() == 1 {
            result.push_str(&line[0]);
            result.push_str(&" ".repeat(spaces));
            return result;
        }
        let base_spaces = spaces / (line.len() - 1);
        let mut extra_spaces = spaces % (line.len() - 1);
        for word in line {
            result.push_str(&word);
            result.push_str(&" ".repeat(base_spaces));
            if extra_spaces > 0 {
                result.push(' ');
                extra_spaces -= 1;
            }
        }
        result
    }
    fn format_last_line(line: Vec<String>, max_width: i32) -> String {
        let mut result = String::new();
        for word in line {
            result.push_str(&word);
            result.push(' ');
        }
        result.pop();
        result.push_str(&" ".repeat((max_width - result.len() as i32) as usize));
        result
    }
}