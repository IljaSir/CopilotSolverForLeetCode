impl Solution {
    pub fn num_matching_subseq(s: String, words: Vec<String>) -> i32 {
        
        let mut res = 0;
        let mut idx = vec![vec![]; 26];
        for (i, c) in s.chars().enumerate() {
            idx[(c as u8 - 'a' as u8) as usize].push(i);
        }
        'outer: for word in words {
            let mut prev = -1;
            for c in word.chars() {
                let c = c as u8 - 'a' as u8;
                match idx[c as usize].binary_search(&prev + 1) {
                    Ok(i) => prev = idx[c as usize][i],
                    Err(i) => {
                        if i == idx[c as usize].len() {
                            continue 'outer;
                        }
                        prev = idx[c as usize][i];
                    }
                }
            }
            res += 1;
        }
        res
    }
}