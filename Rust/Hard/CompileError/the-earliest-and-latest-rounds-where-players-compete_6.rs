impl Solution {
    pub fn earliest_and_latest(n: i32, first_player: i32, second_player: i32) -> Vec<i32> {
        
        let mut round = 1;
        let mut first = first_player;
        let mut second = second_player;
        let mut min = n;
        let mut max = 1;
        while n > 1 {
            if (first + 1) / 2 == (second + 1) / 2 {
                min = min.min(round);
                max = max.max(round);
            }
            first = (first + 1) / 2;
            second = (second + 1) / 2;
            round += 1;
            n = (n + 1) / 2;
        }
        vec![min, max]
    }
}