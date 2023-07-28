impl Solution {
    pub fn generate_parenthesis(n: i32) -> Vec<String> {
        

        let mut ret = vec![];
        let n = n as usize;
        let mut stack = vec![];
        let mut s = String::new();
        let mut i = 0;
        while i < n {
            stack.push((i, 0, 0));
            s.push('(');
            i += 1;
        }
        while let Some((i, l, r)) = stack.pop() {
            if l == n && r == n {
                ret.push(s);
                continue;
            }
            if l < n {
                stack.push((i, l + 1, r));
                s.push('(');
            }
            if l > r {
                stack.push((i, l, r + 1));
                s.push(')');
            }
            s.truncate(i);
        }
        ret
    }
}