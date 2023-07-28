impl Solution {
    pub fn length_longest_path(input: String) -> i32 {
        

        let mut max = 0;
        let mut stack = vec![];
        for s in input.split_terminator('\n') {
            let level = s.chars().take_while(|&c| c == '\t').count();
            while stack.len() > level {
                stack.pop();
            }
            let len = stack.last().unwrap_or(&0) + s.len() - level + 1;
            if s.contains('.') {
                max = max.max(len - 1);
            } else {
                stack.push(len);
            }
        }
        max as i32
    }
}