impl Solution {
    pub fn longest_repeating(s: String, query_characters: String, query_indices: Vec<i32>) -> Vec<i32> {
        
        let mut s = s.into_bytes();
        let mut res = vec![];
        for (i, &c) in query_characters.as_bytes().iter().enumerate() {
            let index = query_indices[i] as usize;
            let old = s[index];
            s[index] = c;
            let mut count = 0;
            let mut max = 0;
            for &c in s.iter() {
                if c == old {
                    count += 1;
                    if count > max {
                        max = count;
                    }
                } else {
                    count = 0;
                }
            }
            res.push(max);
        }
        res
    }
}