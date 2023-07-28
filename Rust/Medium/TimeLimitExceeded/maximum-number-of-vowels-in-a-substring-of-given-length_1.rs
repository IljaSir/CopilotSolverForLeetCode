impl Solution {
    pub fn max_vowels(s: String, k: i32) -> i32 {
        
        let k = k as usize;
        let mut res = 0;
        for i in 0..k {
            if "aeiou".contains(s.chars().nth(i).unwrap()) {
                res += 1;
            }
        }
        let mut cur = res;
        for i in k..s.len() {
            if "aeiou".contains(s.chars().nth(i).unwrap()) {
                cur += 1;
            }
            if "aeiou".contains(s.chars().nth(i - k).unwrap()) {
                cur -= 1;
            }
            res = res.max(cur);
        }
        res
    }
}