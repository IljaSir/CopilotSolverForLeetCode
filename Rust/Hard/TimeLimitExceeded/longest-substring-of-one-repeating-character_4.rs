impl Solution {
    pub fn longest_repeating(s: String, query_characters: String, query_indices: Vec<i32>) -> Vec<i32> {
        
        let mut s: Vec<char> = s.chars().collect();
        let mut result = vec![];
        for (i, &index) in query_indices.iter().enumerate() {
            s[index as usize] = query_characters.chars().nth(i).unwrap();
            let mut max = 0;
            let mut count = 0;
            let mut last = ' ';
            for c in s.iter() {
                if *c == last {
                    count += 1;
                } else {
                    count = 1;
                    last = *c;
                }
                if count > max {
                    max = count;
                }
            }
            result.push(max);
        }
        result
    }
}