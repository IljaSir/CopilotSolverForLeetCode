impl Solution {
    pub fn simplify_path(path: String) -> String {
        

        let mut stack = Vec::new();
        for s in path.split("/") {
            match s {
                "" | "." => (),
                ".." => { stack.pop(); },
                _ => stack.push(s),
            };
        }
        stack.join("/")
    }
}