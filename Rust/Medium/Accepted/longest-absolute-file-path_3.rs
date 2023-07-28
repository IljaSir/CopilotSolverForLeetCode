impl Solution {
    pub fn length_longest_path(input: String) -> i32 {
        

        let mut stack = vec![];
        let mut max_len = 0;
        let mut cur_len = 0;
        for line in input.lines() {
            let level = line.chars().take_while(|&c| c == '\t').count();
            let name = line.chars().skip(level).collect::<String>();
            while stack.len() > level {
                cur_len -= stack.pop().unwrap();
            }
            if name.contains('.') {
                max_len = max_len.max(cur_len + name.len());
            } else {
                stack.push(name.len() + 1);
                cur_len += name.len() + 1;
            }
        }
        max_len as i32
    }
}