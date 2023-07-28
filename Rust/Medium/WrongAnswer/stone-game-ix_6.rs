impl Solution {
    pub fn stone_game_ix(stones: Vec<i32>) -> bool {
        
        let mut sum = 0;
        let mut odd = 0;
        let mut even = 0;
        for i in 0..stones.len() {
            let v = stones[i];
            sum += v;
            if v % 2 == 0 {
                even += 1;
            } else {
                odd += 1;
            }
        }
        if sum % 3 == 0 {
            return odd % 2 == 1;
        } else if sum % 3 == 1 {
            return odd > 0;
        } else {
            return even > 0;
        }
    }
}