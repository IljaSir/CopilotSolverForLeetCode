impl Solution {
    pub fn find_num_of_valid_words(words: Vec<String>, puzzles: Vec<String>) -> Vec<i32> {
        
        let mut map: HashMap<i32, i32> = HashMap::new();
        for word in words {
            let mut mask = 0;
            for c in word.as_bytes() {
                mask |= 1 << (*c - b'a');
            }
            if mask.count_ones() <= 7 {
                *map.entry(mask).or_insert(0) += 1;
            }
        }
        let mut res = Vec::new();
        for puzzle in puzzles {
            let mut mask = 0;
            for c in puzzle.as_bytes() {
                mask |= 1 << (*c - b'a');
            }
            let mut sub = mask;
            let mut cnt = 0;
            while sub != 0 {
                if (sub & (1 << (puzzle.as_bytes()[0] - b'a'))) != 0 {
                    cnt += *map.get(&sub).unwrap_or(&0);
                }
                sub = (sub - 1) & mask;
            }
            res.push(cnt);
        }
        res
    }
}