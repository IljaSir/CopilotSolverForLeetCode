impl Solution {
    pub fn maximize_win(prize_positions: Vec<i32>, k: i32) -> i32 {
        
        let mut result = 0;
        let mut i = 0;
        let mut j = 0;
        let mut map = std::collections::HashMap::new();
        while j < prize_positions.len() {
            *map.entry(prize_positions[j]).or_insert(0) += 1;
            if prize_positions[j] - prize_positions[i] > k {
                *map.entry(prize_positions[i]).or_insert(0) -= 1;
                i += 1;
            }
            result = std::cmp::max(result, map.values().sum());
            j += 1;
        }
        result
    }
}