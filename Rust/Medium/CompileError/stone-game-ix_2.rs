impl Solution {
    pub fn stone_game_ix(stones: Vec<i32>) -> bool {
        
        let mut sum = 0;
        let mut odd = 0;
        let mut even = 0;
        for i in 0..stones.len() {
            sum += stones[i];
            if stones[i] % 2 == 1 {
                odd += 1;
            } else {
                even += 1;
            }
        }
        if sum % 3 == 0 {
            if odd % 2 == 0 {
                return true;
            } else {
                return false;
            }
        } else if sum % 3 == 1 {
            if odd > 0 {
                return true;
            } else {
                return false;
            }
        } else {
            if odd > 1 {
                return true;
            } else {
                return false;
            }
        }