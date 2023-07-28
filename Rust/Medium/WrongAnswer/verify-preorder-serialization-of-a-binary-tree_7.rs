impl Solution {
    pub fn is_valid_serialization(preorder: String) -> bool {
        

        let mut stack = vec![];
        for c in preorder.chars() {
            if c == ',' {
                continue;
            }
            if c == '#' {
                while stack.len() >= 2 {
                    if stack[stack.len() - 1] != '#' || stack[stack.len() - 2] == '#' {
                        break;
                    }
                    stack.pop();
                    stack.pop();
                }
                stack.push('#');
            } else {
                stack.push(c);
            }
        }
        stack.len() == 1 && stack[0] == '#'
    }
}