impl Solution {
    pub fn stone_game_ix(stones: Vec<i32>) -> bool {
        
        let mut sum = 0;
        let mut odd = 0;
        let mut even = 0;
        for i in 0..stones.len() {
            if stones[i] % 2 == 0 {
                even += 1;
            } else {
                odd += 1;
            }
            sum += stones[i];
        }
        if odd % 2 == 0 {
            return sum % 3 != 1;
        } else {
            return sum % 3 != 2;
        }
    }
}