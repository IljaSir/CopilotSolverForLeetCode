impl Solution {
    pub fn minimum_card_pickup(cards: Vec<i32>) -> i32 {
        
        let mut count: i32 = 0;
        let mut map: HashMap<i32, i32> = HashMap::new();
        for card in cards {
            let counter = map.entry(card).or_insert(0);
            *counter += 1;
        }
        for (_, value) in map {
            if value % 2 != 0 {
                count += 1;
            }
        }
        if count % 2 == 0 {
            return count / 2;
        } else {
            return -1;
        }
    }
}