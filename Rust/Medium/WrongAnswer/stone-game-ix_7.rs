impl Solution {
    pub fn stone_game_ix(stones: Vec<i32>) -> bool {
        
        let mut cnt = vec![0; 3];
        for &v in stones.iter() {
            cnt[v as usize % 3] += 1;
        }
        if cnt[0] % 2 == 0 {
            cnt[1] > cnt[2]
        } else {
            cnt[1] != cnt[2]
        }
    }
}