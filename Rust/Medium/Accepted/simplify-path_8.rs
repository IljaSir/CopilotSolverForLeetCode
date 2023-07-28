impl Solution {
    pub fn simplify_path(path: String) -> String {
        

        let mut stack = Vec::new();
        let mut path = path.split("/").collect::<Vec<&str>>();
        for i in path {
            if i == "." || i == "" {
                continue;
            } else if i == ".." {
                stack.pop();
            } else {
                stack.push(i);
            }
        }
        format!("/{}", stack.join("/"))
    }
}