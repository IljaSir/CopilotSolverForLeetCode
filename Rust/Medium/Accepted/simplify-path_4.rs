impl Solution {
    pub fn simplify_path(path: String) -> String {
        

        let mut stack: Vec<String> = Vec::new();
        for part in path.split('/') {
            match part {
                "" | "." => (),
                ".." => { stack.pop(); }
                _ => { stack.push(part.to_string()); }
            }
        }
        let res: String = stack.join("/");
        format!("/{}", res)
    }
}