impl Solution {
    pub fn earliest_and_latest(n: i32, first_player: i32, second_player: i32) -> Vec<i32> {
        
        let mut round = 0;
        let mut first = first_player;
        let mut second = second_player;
        let mut earliest = 0;
        let mut latest = 0;
        loop {
            round += 1;
            if first > second {
                let tmp = first;
                first = second;
                second = tmp;
            }
            if first % 2 == 1 && first + 1 == second {
                earliest = round;
                break;
            }
            first = (first + 1) / 2;
            second = (second + 1) / 2;
        }
        while n / 2i32.pow(latest) > 1 {
            latest += 1;
        }
        return vec![earliest, latest];
    }
}