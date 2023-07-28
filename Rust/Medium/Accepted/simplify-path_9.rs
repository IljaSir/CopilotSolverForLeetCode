impl Solution {
    pub fn simplify_path(path: String) -> String {
        

        let mut stack: Vec<String> = Vec::new();
        let mut path = path.split("/");
        loop {
            let p = path.next();
            match p {
                Some(p) => {
                    match p {
                        "" => continue,
                        "." => continue,
                        ".." => {
                            stack.pop();
                        }
                        _ => {
                            stack.push(p.to_string());
                        }
                    }
                }
                None => break,
            }
        }
        let mut res = String::from("/");
        for p in stack {
            res.push_str(&p);
            res.push('/');
        }
        if res.len() > 1 {
            res.pop();
        }
        return res;
    }
}