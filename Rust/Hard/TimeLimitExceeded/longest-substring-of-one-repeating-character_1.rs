impl Solution {
    pub fn longest_repeating(s: String, query_characters: String, query_indices: Vec<i32>) -> Vec<i32> {
        
        let mut s = s.into_bytes();
        let mut ans = vec![];
        for i in 0..query_indices.len() {
            s[query_indices[i] as usize] = query_characters.as_bytes()[i];
            ans.push(Self::longest_repeating_substring(&s));
        }
        ans
    }
    fn longest_repeating_substring(s: &[u8]) -> i32 {
        let mut ans = 1;
        let mut cnt = 1;
        for i in 1..s.len() {
            if s[i] == s[i-1] {
                cnt += 1;
            } else {
                cnt = 1;
            }
            ans = ans.max(cnt);
        }
        ans
    }
}