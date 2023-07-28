impl Solution {
    pub fn stone_game_ix(stones: Vec<i32>) -> bool {
        
        let mut sum = 0;
        let mut count = vec![0; 3];
        for &s in &stones {
            sum += s;
            count[s as usize % 3] += 1;
        }
        if sum % 3 == 0 {
            count[0] > 0 && count[1] > 0
        } else {
            count[sum as usize % 3] > 0
        }
    }
}