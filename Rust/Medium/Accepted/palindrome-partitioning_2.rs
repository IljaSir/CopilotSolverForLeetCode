impl Solution {
    pub fn partition(s: String) -> Vec<Vec<String>> {
        

        let mut res = vec![];
        let mut path = vec![];
        let chars: Vec<char> = s.chars().collect();
        Solution::backtrack(&mut res, &mut path, &chars, 0);
        res
    }
    
    fn backtrack(res: &mut Vec<Vec<String>>, path: &mut Vec<String>, chars: &Vec<char>, start: usize) {
        if start == chars.len() {
            res.push(path.clone());
            return;
        }
        for i in start..chars.len() {
            if !Solution::is_palindrome(chars, start, i) {
                continue;
            }
            path.push(chars[start..=i].iter().collect());
            Solution::backtrack(res, path, chars, i + 1);
            path.pop();
        }
    }
    
    fn is_palindrome(chars: &Vec<char>, start: usize, end: usize) -> bool {
        let mut i = start;
        let mut j = end;
        while i < j {
            if chars[i] != chars[j] {
                return false;
            }
            i += 1;
            j -= 1;
        }
        true
    }
}