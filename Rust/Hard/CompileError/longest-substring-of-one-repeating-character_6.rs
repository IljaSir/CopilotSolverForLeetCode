impl Solution {
    pub fn longest_repeating(s: String, query_characters: String, query_indices: Vec<i32>) -> Vec<i32> {
        
        let mut s = s.chars().collect::<Vec<char>>();
        let mut ans = vec![];
        for (i, &c) in query_characters.chars().enumerate() {
            let idx = query_indices[i] as usize;
            let old = s[idx];
            s[idx] = c;
            ans.push(Self::longest_repeating_substring(s.as_slice()));
            s[idx] = old;
        }
        ans
    }
    fn longest_repeating_substring(s: &[char]) -> i32 {
        let mut ans = 1;
        let mut cur = 1;
        for i in 1..s.len() {
            if s[i] == s[i - 1] {
                cur += 1;
            } else {
                ans = ans.max(cur);
                cur = 1;
            }
        }
        ans.max(cur)
    }
}