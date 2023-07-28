impl Solution {
    pub fn longest_repeating(s: String, query_characters: String, query_indices: Vec<i32>) -> Vec<i32> {
        
        let mut s = s.into_bytes();
        let query_characters = query_characters.into_bytes();
        let mut res = vec![];
        for (i, &c) in query_characters.iter().enumerate() {
            s[query_indices[i] as usize] = c;
            let mut max = 0;
            let mut curr = 0;
            let mut prev = 0;
            for &c in s.iter() {
                if c == prev {
                    curr += 1;
                } else {
                    max = max.max(curr);
                    curr = 1;
                    prev = c;
                }
            }
            max = max.max(curr);
            res.push(max);
        }
        res
    }
}