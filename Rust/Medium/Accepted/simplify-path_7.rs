impl Solution {
    pub fn simplify_path(path: String) -> String {
        

        let mut stack = vec![];
        let mut parts = path.split('/');
        for part in parts {
            match part {
                ".." => { stack.pop(); },
                "." | "" => {},
                _ => { stack.push(part); },
            }
        }
        let mut res = String::new();
        for part in stack {
            res.push('/');
            res.push_str(part);
        }
        if res.is_empty() { res.push('/') }
        res
    }
}