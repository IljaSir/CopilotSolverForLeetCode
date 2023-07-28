impl Solution {
    pub fn partition(s: String) -> Vec<Vec<String>> {
        

        let mut result = Vec::new();
        let mut path = Vec::new();
        let s: Vec<char> = s.chars().collect();
        Solution::backtrack(&s, 0, &mut path, &mut result);
        result
    }
    fn backtrack(s: &[char], start: usize, path: &mut Vec<String>, result: &mut Vec<Vec<String>>) {
        if start == s.len() {
            result.push(path.clone());
            return;
        }
        for i in start..s.len() {
            if Solution::is_palindrome(s, start, i) {
                path.push(s[start..=i].iter().collect());
                Solution::backtrack(s, i + 1, path, result);
                path.pop();
            }
        }
    }
    fn is_palindrome(s: &[char], start: usize, end: usize) -> bool {
        let mut start = start;
        let mut end = end;
        while start < end {
            if s[start] != s[end] {
                return false;
            }
            start += 1;
            end -= 1;
        }
        true
    }
}