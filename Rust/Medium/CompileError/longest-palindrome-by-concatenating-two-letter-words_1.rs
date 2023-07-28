impl Solution {
    pub fn longest_palindrome(words: Vec<String>) -> i32 {
        
        let mut res = 0;
        let mut cnt = vec![0; 26];
        for word in words {
            let mut mask = 0;
            for c in word.chars() {
                mask ^= 1 << (c as u8 - b'a');
            }
            cnt[mask.count_ones() as usize] += 1;
        }
        res += cnt[0] / 2 * 2;
        for i in 1..26 {
            for j in 1..26 {
                if i == j {
                    continue;
                }
                res += cnt[i].min(cnt[j]);
            }
        }
        res
    }
}