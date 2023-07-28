impl Solution {
    pub fn generate_parenthesis(n: i32) -> Vec<String> {
        

        let mut result = Vec::new();
        Self::generate_parenthesis_helper(&mut result, String::new(), 0, 0, n);
        result
    }
    
    fn generate_parenthesis_helper(result: &mut Vec<String>, s: String, left: i32, right: i32, n: i32) {
        if left == n && right == n {
            result.push(s);
            return;
        }
        
        if left < n {
            let mut s1 = s.clone();
            s1.push('(');
            Self::generate_parenthesis_helper(result, s1, left + 1, right, n);
        }
        
        if right < left {
            let mut s1 = s.clone();
            s1.push(')');
            Self::generate_parenthesis_helper(result, s1, left, right + 1, n);
        }
    }
}