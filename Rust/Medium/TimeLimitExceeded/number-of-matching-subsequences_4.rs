impl Solution {
    pub fn num_matching_subseq(s: String, words: Vec<String>) -> i32 {
        
        let mut res = 0;
        let mut arr = vec![vec![]; 26];
        for word in words {
            arr[word.as_bytes()[0] as usize - 97].push(word);
        }
        for c in s.chars() {
            let mut i = 0;
            while i < arr[c as usize - 97].len() {
                let mut word = arr[c as usize - 97][i].clone();
                if word.len() == 1 {
                    res += 1;
                    arr[c as usize - 97].swap_remove(i);
                } else {
                    arr[c as usize - 97][i].remove(0);
                    arr[word.as_bytes()[0] as usize - 97].push(word);
                    i += 1;
                }
            }
        }
        res
    }
}