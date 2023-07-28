impl Solution {
    pub fn partition(s: String) -> Vec<Vec<String>> {
        

        let mut res = vec![];
        let mut path = vec![];
        let chars: Vec<char> = s.chars().collect();
        Self::backtrack(0, &chars, &mut path, &mut res);
        res
    }
    
    fn backtrack(start: usize, chars: &Vec<char>, path: &mut Vec<String>, res: &mut Vec<Vec<String>>) {
        if start == chars.len() {
            res.push(path.clone());
            return;
        }
        for i in start..chars.len() {
            if Self::is_palindrome(start, i, chars) {
                path.push(chars[start..=i].iter().collect());
                Self::backtrack(i + 1, chars, path, res);
                path.pop();
            }
        }
    }
    
    fn is_palindrome(left: usize, right: usize, chars: &Vec<char>) -> bool {
        let mut left = left;
        let mut right = right;
        while left < right {
            if chars[left] != chars[right] {
                return false;
            }
            left += 1;
            right -= 1;
        }
        true
    }
}