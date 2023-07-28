impl Solution {
    pub fn generate_parenthesis(n: i32) -> Vec<String> {
        

        let mut res = Vec::new();
        Self::gen(&mut res, n, n, String::new());
        res
    }
    
    fn gen(res: &mut Vec<String>, left: i32, right: i32, mut s: String) {
        if left > right {
            return;
        }
        if left == 0 && right == 0 {
            res.push(s);
            return;
        }
        if left > 0 {
            s.push('(');
            Self::gen(res, left - 1, right, s.clone());
            s.pop();
        }
        if right > 0 {
            s.push(')');
            Self::gen(res, left, right - 1, s.clone());
            s.pop();
        }
    }
}