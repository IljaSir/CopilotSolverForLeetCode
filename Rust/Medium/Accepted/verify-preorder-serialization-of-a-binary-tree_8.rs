impl Solution {
    pub fn is_valid_serialization(preorder: String) -> bool {
        

        let mut stack = Vec::new();
        for s in preorder.split(",") {
            if s == "#" {
                while let Some(&"#") = stack.last() {
                    stack.pop();
                    if stack.is_empty() {
                        return false;
                    }
                    stack.pop();
                }
            }
            stack.push(s);
        }
        stack.len() == 1 && stack[0] == "#"
    }
}