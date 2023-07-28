impl Solution {
    pub fn last_stone_weight(stones: Vec<i32>) -> i32 {
        
        let mut stones = stones;
        stones.sort();
        while stones.len() > 1 {
            let len = stones.len();
            let x = stones[len - 1];
            let y = stones[len - 2];
            stones.pop();
            stones.pop();
            if x != y {
                stones.push(x - y);
            }
            stones.sort();
        }
        if stones.len() == 1 {
            return stones[0];
        }
        0
    }
}