impl Solution {
    pub fn stone_game_ix(stones: Vec<i32>) -> bool {
        
        let mut sum = 0;
        let mut odd = 0;
        let mut even = 0;
        for stone in stones {
            sum += stone;
            if stone % 2 == 0 {
                even += 1;
            } else {
                odd += 1;
            }
        }
        if sum % 3 == 0 {
            even > 0 && odd > 0
        } else if sum % 3 == 1 {
            odd > 1
        } else {
            even > 1
        }
    }
}