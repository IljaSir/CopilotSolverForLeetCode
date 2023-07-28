impl Solution {
    pub fn wonderful_substrings(word: String) -> i64 {
        
        let mut count = vec![1; 1024];
        let mut mask = 0;
        let mut ans = 0;
        for c in word.chars() {
            mask ^= 1 << (c as u8 - b'a');
            ans += count[mask];
            for i in 0..10 {
                ans += count[mask ^ (1 << i)];
            }
            count[mask] += 1;
        }
        ans
    }
}