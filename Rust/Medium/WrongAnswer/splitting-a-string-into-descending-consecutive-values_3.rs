impl Solution {
    pub fn split_string(s: String) -> bool {
        
        let mut s = s.into_bytes();
        let mut stack = Vec::new();
        Self::dfs(&mut s, &mut stack, 0)
    }
    
    fn dfs(s: &mut [u8], stack: &mut Vec<u8>, start: usize) -> bool {
        if start == s.len() {
            return stack.len() > 1;
        }
        
        let mut num = 0;
        for i in start..s.len() {
            num = num * 10 + (s[i] - b'0');
            if stack.is_empty() || num == stack[stack.len() - 1] - 1 {
                stack.push(num);
                if Self::dfs(s, stack, i + 1) {
                    return true;
                }
                stack.pop();
            }
        }
        false
    }
}