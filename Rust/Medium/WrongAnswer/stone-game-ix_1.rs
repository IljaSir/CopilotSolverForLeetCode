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
            if odd == 0 {
                return false;
            } else if even == 0 {
                return odd % 2 == 0;
            } else {
                return true;
            }
        } else if sum % 3 == 1 {
            return odd >= 1;
        } else {
            return even >= 1;
        }
    }
}