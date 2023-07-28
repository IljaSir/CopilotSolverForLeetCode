impl Solution {
    pub fn last_stone_weight(stones: Vec<i32>) -> i32 {
        
        let mut stones = stones;
        stones.sort();
        while stones.len() > 1 {
            let x = stones.pop().unwrap();
            let y = stones.pop().unwrap();
            if x != y {
                let i = stones.binary_search(&(x - y)).unwrap_or_else(|x| x);
                stones.insert(i, x - y);
            }
        }
        stones.get(0).cloned().unwrap_or(0)
    }
}