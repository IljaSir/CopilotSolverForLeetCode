impl Solution {
    pub fn minimum_card_pickup(cards: Vec<i32>) -> i32 {
        
        let mut map: std::collections::HashMap<i32, i32> = std::collections::HashMap::new();
        let mut min: i32 = -1;
        for card in cards {
            if let Some(val) = map.get(&card) {
                if min == -1 {
                    min = *val;
                } else {
                    min = min.min(*val);
                }
            }
            map.entry(card).and_modify(|x| *x += 1).or_insert(1);
        }
        min
    }
}