impl Solution {
    pub fn simplify_path(path: String) -> String {
        

        let mut stack = Vec::new();
        for p in path.split('/') {
            match p {
                "" | "." => (),
                ".." => { stack.pop(); },
                _ => { stack.push(p); },
            }
        }
        format!("/{}", stack.join("/"))
    }
}