impl Solution {
    pub fn min_deletions(s: String) -> i32 {
        
        let mut freq = vec![0; 26];
        for c in s.chars() {
            freq[c as usize - 'a' as usize] += 1;
        }
        let mut freq = freq.iter().filter(|&x| *x != 0).collect::<Vec<&i32>>();
        freq.sort();
        let mut res = 0;
        for i in 1..freq.len() {
            if freq[i] <= freq[i - 1] {
                res += freq[i - 1] + 1 - freq[i];
                freq[i] = freq[i - 1] + 1;
            }
        }
        res
    }
}