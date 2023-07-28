impl Solution {
    pub fn num_matching_subseq(s: String, words: Vec<String>) -> i32 {
        
        let mut words = words.into_iter().map(|word| word.into_bytes().into_iter().collect::<VecDeque<_>>()).collect::<Vec<_>>();
        let mut count = 0;
        for c in s.bytes() {
            for word in &mut words {
                if word.len() > 0 && word[0] == c {
                    word.pop_front();
                    if word.len() == 0 {
                        count += 1;
                    }
                }
            }
        }
        count
    }
}