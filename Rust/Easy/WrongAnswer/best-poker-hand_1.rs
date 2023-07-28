impl Solution {
    pub fn best_hand(ranks: Vec<i32>, suits: Vec<char>) -> String {
        
        let mut rank_count = [0; 13];
        let mut suit_count = [0; 4];
        for i in 0..5 {
            rank_count[(ranks[i] - 1) as usize] += 1;
            suit_count[suits[i] as usize - 97] += 1;
        }
        let mut rank_count = rank_count.iter().map(|&x| x).collect::<Vec<_>>();
        rank_count.sort_unstable_by(|a, b| b.cmp(a));
        let mut suit_count = suit_count.iter().map(|&x| x).collect::<Vec<_>>();
        suit_count.sort_unstable_by(|a, b| b.cmp(a));
        if suit_count[0] == 5 {
            return "Flush".to_string();
        }
        if rank_count[0] == 3 {
            return "Three of a Kind".to_string();
        }
        if rank_count[0] == 2 && rank_count[1] == 2 {
            return "Pair".to_string();
        }
        "High Card".to_string()
    }
}