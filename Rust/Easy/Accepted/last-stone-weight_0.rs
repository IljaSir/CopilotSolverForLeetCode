impl Solution {
    pub fn last_stone_weight(stones: Vec<i32>) -> i32 {
        
        let mut stones = stones;
        while stones.len() > 1 {
            stones.sort();
            let x = stones.pop().unwrap();
            let y = stones.pop().unwrap();
            if x != y {
                stones.push(x - y);
            }
        }
        if stones.is_empty() {
            0
        } else {
            stones[0]
        }
    }
}