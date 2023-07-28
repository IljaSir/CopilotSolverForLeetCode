impl Solution {
    pub fn appeal_sum(s: String) -> i64 {
        
        let mut result: i64 = 0;
        let mut count: Vec<i64> = vec![0; 26];
        let mut distinct: i64 = 0;
        for (i, ch) in s.chars().enumerate() {
            let idx = (ch as u8 - 'a' as u8) as i64;
            count[idx as usize] += 1;
            if count[idx as usize] == 1 {
                distinct += 1;
            }
            result += distinct;
        }
        result
    }
}