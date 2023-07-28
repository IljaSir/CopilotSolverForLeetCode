impl Solution {
    pub fn earliest_and_latest(n: i32, first_player: i32, second_player: i32) -> Vec<i32> {
        
        let mut first_player = first_player;
        let mut second_player = second_player;
        if first_player > second_player {
            std::mem::swap(&mut first_player, &mut second_player);
        }
        let mut round = 0;
        let mut min = 0;
        let mut max = 0;
        while n > (1 << round) {
            round += 1;
            let mid = 1 << (round - 1);
            if first_player <= mid && second_player > mid {
                min = round;
                max = round;
            } else {
                if first_player > mid {
                    first_player -= mid;
                }
                if second_player > mid {
                    second_player -= mid;
                }
            }
        }
        if max == 0 {
            max = round;
        }
        vec![min, max]
    }
}