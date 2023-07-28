impl Solution {
    pub fn stone_game_ix(stones: Vec<i32>) -> bool {
        
        let mut sum = 0;
        let mut odd = 0;
        let mut even = 0;
        for stone in stones {
            sum += stone;
            if stone % 2 == 1 {
                odd += 1;
            } else {
                even += 1;
            }
        }
        let sum = sum % 3;
        if sum == 0 {
            true
        } else if sum == 1 {
            odd >= 1 && even >= 2
        } else {
            odd >= 2 && even >= 1
        }
    }
}