impl Solution {
    pub fn last_stone_weight(stones: Vec<i32>) -> i32 {
        
        let mut stones = stones;
        stones.sort();
        while stones.len() > 1 {
            let last = stones.pop().unwrap();
            let prev = stones.pop().unwrap();
            if last != prev {
                stones.push(last - prev);
                stones.sort();
            }
        }
        if stones.len() == 1 {
            return stones[0];
        }
        0
    }
}