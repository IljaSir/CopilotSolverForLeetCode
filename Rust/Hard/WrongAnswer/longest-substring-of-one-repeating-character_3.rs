impl Solution {
    pub fn longest_repeating(s: String, query_characters: String, query_indices: Vec<i32>) -> Vec<i32> {
        
        let mut s = s.into_bytes();
        let query_characters = query_characters.into_bytes();
        let mut res = vec![];
        for (i, &c) in query_characters.iter().enumerate() {
            s[query_indices[i] as usize] = c;
            let mut cnt = 0;
            let mut max = 0;
            for &c in s.iter() {
                if c == query_characters[i] {
                    cnt += 1;
                    if cnt > max {
                        max = cnt;
                    }
                } else {
                    cnt = 0;
                }
            }
            res.push(max);
        }
        res
    }
}