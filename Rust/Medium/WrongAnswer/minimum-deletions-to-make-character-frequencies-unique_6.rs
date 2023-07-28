impl Solution {
    pub fn min_deletions(s: String) -> i32 {
        
        let mut freq: Vec<i32> = vec![0; 26];
        for c in s.chars() {
            let i = (c as u8 - b'a') as usize;
            freq[i] += 1;
        }
        let mut freq = freq.into_iter().filter(|&x| x > 0).collect::<Vec<i32>>();
        freq.sort();
        freq.reverse();
        let mut res = 0;
        for i in 1..freq.len() {
            if freq[i] >= freq[i-1] {
                res += freq[i] - freq[i-1] + 1;
                freq[i] = freq[i-1] - 1;
            }
        }
        res
    }
}