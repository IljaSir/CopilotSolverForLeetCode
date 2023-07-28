impl Solution {
    pub fn simplify_path(path: String) -> String {
        

        let mut stack = Vec::new();
        for p in path.split('/') {
            match p {
                "" | "." => continue,
                ".." => { stack.pop(); },
                _ => { stack.push(p); },
            }
        }
        let mut result = String::new();
        for p in stack {
            result.push('/');
            result.push_str(p);
        }
        if result.is_empty() {
            result.push('/');
        }
        result
    }
}