impl Solution {
    pub fn simplify_path(path: String) -> String {
        

        let mut stack = Vec::new();
        for p in path.split('/') {
            match p {
                "" | "." => {}
                ".." => { stack.pop(); }
                _ => { stack.push(p); }
            }
        }
        let mut res = String::new();
        for p in stack {
            res.push_str("/");
            res.push_str(p);
        }
        if res.is_empty() { res.push_str("/"); }
        res
    }
}