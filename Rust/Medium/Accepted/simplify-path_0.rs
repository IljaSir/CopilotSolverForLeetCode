impl Solution {
    pub fn simplify_path(path: String) -> String {
        

        let mut stack: Vec<String> = Vec::new();
        for p in path.split("/") {
            if p == "" || p == "." {
                continue;
            } else if p == ".." {
                stack.pop();
            } else {
                stack.push(p.to_string());
            }
        }
        let mut res = String::new();
        for s in stack {
            res.push_str("/");
            res.push_str(&s);
        }
        if res == "" {
            res.push_str("/");
        }
        res
    }
}