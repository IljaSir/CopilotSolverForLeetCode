impl Solution {
    pub fn length_longest_path(input: String) -> i32 {
        

        let mut stack: Vec<i32> = Vec::new();
        stack.push(0);
        let mut result = 0;
        for line in input.lines() {
            let level = line.chars().take_while(|c| *c == '\t').count() as i32;
            while level + 1 < stack.len() as i32 {
                stack.pop();
            }
            let len = stack.last().unwrap() + line.len() as i32 - level;
            stack.push(len);
            if line.contains('.') {
                result = result.max(len + (stack.len() - 2) as i32);
            }
        }
        result
    }
}