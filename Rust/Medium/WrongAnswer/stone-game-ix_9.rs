impl Solution {
    pub fn stone_game_ix(stones: Vec<i32>) -> bool {
        
        let mut cnt = vec![0;3];
        for stone in stones {
            cnt[stone as usize % 3] += 1;
        }
        let mut turn = true;
        let mut a = 0;
        let mut b = 0;
        while cnt[1] > 0 || cnt[2] > 0 {
            if turn {
                if cnt[2] > 0 {
                    cnt[2] -= 1;
                    a += 2;
                } else {
                    cnt[1] -= 1;
                    a += 1;
                }
            } else {
                if cnt[1] > 0 {
                    cnt[1] -= 1;
                    b += 1;
                } else {
                    cnt[2] -= 1;
                    b += 2;
                }
            }
            turn = !turn;
        }
        if a % 3 == 0 {
            return false;
        }
        if b % 3 == 0 {
            return true;
        }
        if cnt[0] > 0 {
            return true;
        }
        false
    }
}