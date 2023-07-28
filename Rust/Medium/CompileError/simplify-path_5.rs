impl Solution {
    pub fn simplify_path(path: String) -> String {
        

        let mut stack = Vec::new();
        for sub in path.split('/') {
            match sub {
                "." | "" => (),
                ".." => { stack.pop(); },
                _ => { stack.push(sub); },
            }
        }
        stack.join("/").insert(0, '/')
    }
}