impl Solution {
    pub fn second_highest(s: String) -> i32 {
        
        let mut v: Vec<i32> = s.chars()
            .filter(|c| c.is_digit(10))
            .map(|c| c.to_digit(10).unwrap() as i32)
            .collect();
        v.sort();
        v.dedup();
        if v.len() < 2 {
            -1
        } else {
            v[v.len() - 2]
        }
    }
}