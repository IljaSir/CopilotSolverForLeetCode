impl Solution {
    pub fn earliest_and_latest(n: i32, first_player: i32, second_player: i32) -> Vec<i32> {
        
        let mut round = 0;
        let mut fp = first_player;
        let mut sp = second_player;
        let mut res = vec![0, 0];
        while n > 1 {
            round += 1;
            fp = (fp + 1) / 2;
            sp = (sp + 1) / 2;
            if fp == sp {
                res[0] = round;
                res[1] = round;
                break;
            }
            if (fp - sp).abs() == 1 {
                res[0] = round;
            }
        }
        res[1] = round;
        res
    }
}