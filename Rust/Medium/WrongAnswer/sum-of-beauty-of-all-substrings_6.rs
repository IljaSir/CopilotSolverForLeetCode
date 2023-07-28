impl Solution {
    pub fn beauty_sum(s: String) -> i32 {
        
        let mut sum = 0;
        let mut chars = s.chars().collect::<Vec<char>>();
        for i in 0..chars.len() {
            let mut freq = vec![0; 26];
            for j in i..chars.len() {
                let x = chars[j] as usize - 'a' as usize;
                freq[x] += 1;
                sum += freq.iter().max().unwrap() - freq.iter().min().unwrap();
            }
        }
        sum
    }
}