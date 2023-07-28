impl Solution {
    pub fn equal_substring(s: String, t: String, max_cost: i32) -> i32 {
        
        let s: Vec<char> = s.chars().collect();
        let t: Vec<char> = t.chars().collect();
        let mut cost: Vec<i32> = s.iter().zip(t.iter()).map(|(a, b)| (a as u8 - b as u8) as i32).collect();
        let mut cost_sum: i32 = 0;
        let mut max_len: i32 = 0;
        let mut start: i32 = 0;
        for (i, c) in cost.iter().enumerate() {
            cost_sum += c;
            if cost_sum <= max_cost {
                max_len = i as i32 + 1;
            } else {
                cost_sum -= cost[start as usize];
                start += 1;
            }
        }
        max_len
    }
}