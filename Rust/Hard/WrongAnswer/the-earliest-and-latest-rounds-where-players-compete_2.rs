impl Solution {
    pub fn earliest_and_latest(n: i32, first_player: i32, second_player: i32) -> Vec<i32> {
        
        let mut min = 0;
        let mut max = 0;
        let mut p1 = first_player;
        let mut p2 = second_player;
        if p1 > p2 {
            p1 = second_player;
            p2 = first_player;
        }
        let mut i = 0;
        while i < 32 {
            if p1 % 2 == 1 && p2 - p1 == 1 {
                break;
            }
            p1 = (p1 + 1) / 2;
            p2 = (p2 + 1) / 2;
            i += 1;
        }
        min = i;
        while n > 1 << i {
            i += 1;
        }
        max = i;
        vec![min + 1, max + 1]
    }
}