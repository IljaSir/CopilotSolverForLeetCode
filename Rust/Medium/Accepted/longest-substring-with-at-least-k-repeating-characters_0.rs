impl Solution {
    pub fn longest_substring(s: String, k: i32) -> i32 {
        

        let mut freq = vec![0; 26];
        for c in s.chars() {
            freq[(c as u8 - 'a' as u8) as usize] += 1;
        }
        let mut split = -1;
        for i in 0..s.len() {
            if freq[(s.as_bytes()[i] - 'a' as u8) as usize] < k {
                split = i as i32;
                break;
            }
        }
        if split == -1 {
            return s.len() as i32;
        }
        let left = Solution::longest_substring(s[0..(split as usize)].to_string(), k);
        let right = Solution::longest_substring(s[(split + 1) as usize..].to_string(), k);
        left.max(right)
    }
}