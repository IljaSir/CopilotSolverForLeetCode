impl Solution {
    pub fn partition(s: String) -> Vec<Vec<String>> {
        

        let mut res: Vec<Vec<String>> = Vec::new();
        Self::partition_helper(&mut res, &mut Vec::new(), &s);
        res
    }
    
    fn partition_helper(res: &mut Vec<Vec<String>>, path: &mut Vec<String>, s: &str) {
        if s.is_empty() {
            res.push(path.clone());
            return;
        }
        for i in 1..=s.len() {
            let (left, right) = s.split_at(i);
            if Self::is_palindrome(left) {
                path.push(left.to_owned());
                Self::partition_helper(res, path, right);
                path.pop();
            }
        }
    }
    
    fn is_palindrome(s: &str) -> bool {
        let mut chars: Vec<char> = s.chars().collect();
        chars.reverse();
        s == chars.iter().collect::<String>().as_str()
    }
}