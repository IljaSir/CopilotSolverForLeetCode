impl Solution {
    pub fn num_matching_subseq(s: String, words: Vec<String>) -> i32 {
        
        let mut ans = 0;
        let mut words: Vec<Vec<char>> = words.into_iter().map(|word| word.chars().collect()).collect();
        let mut pos: Vec<Vec<usize>> = vec![vec![]; 26];
        for (i, ch) in s.chars().enumerate() {
            pos[ch as usize - 'a' as usize].push(i);
        }
        for word in words {
            let mut cur = 0;
            let mut ok = true;
            for ch in word {
                let index = ch as usize - 'a' as usize;
                let next = pos[index].binary_search(&cur);
                if let Ok(i) = next {
                    cur = pos[index][i] + 1;
                } else if let Err(i) = next {
                    if i == pos[index].len() {
                        ok = false;
                        break;
                    }
                    cur = pos[index][i] + 1;
                }
            }
            if ok {
                ans += 1;
            }
        }
        ans
    }
}