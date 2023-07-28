impl Solution {
    pub fn match_players_and_trainers(players: Vec<i32>, trainers: Vec<i32>) -> i32 {
        
        let mut players = players;
        let mut trainers = trainers;
        players.sort();
        trainers.sort();
        let mut i = 0;
        let mut j = 0;
        let mut n = 0;
        while i < players.len() && j < trainers.len() {
            if players[i] <= trainers[j] {
                n += 1;
                i += 1;
                j += 1;
            } else {
                j += 1;
            }
        }
        n
    }
}