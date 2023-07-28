impl Solution {
    pub fn earliest_and_latest(n: i32, first_player: i32, second_player: i32) -> Vec<i32> {
        
        let mut min = 1;
        let mut max = 1;
        let mut n = n;
        while n > 2 {
            let half = n / 2;
            let mid = half + 1;
            let (f, s) = if first_player <= half && second_player <= half {
                (first_player, second_player)
            } else if first_player > half && second_player > half {
                (first_player - half, second_player - half)
            } else {
                (first_player, second_player)
            };
            if f < s && s - f != 1 {
                min += 1;
            }
            if f > mid || s <= mid {
                max += 1;
            }
            n = half;
        }
        vec![min, max]
    }
}