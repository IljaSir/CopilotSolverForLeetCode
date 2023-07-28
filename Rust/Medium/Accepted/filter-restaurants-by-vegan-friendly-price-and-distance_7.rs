impl Solution {
    pub fn filter_restaurants(restaurants: Vec<Vec<i32>>, vegan_friendly: i32, max_price: i32, max_distance: i32) -> Vec<i32> {
        
        let mut res = restaurants
            .iter()
            .filter(|&v| {
                if vegan_friendly == 1 {
                    v[2] == 1
                } else {
                    true
                }
            })
            .filter(|&v| v[3] <= max_price)
            .filter(|&v| v[4] <= max_distance)
            .collect::<Vec<_>>();
        res.sort_by_key(|&v| (v[1], v[0]));
        res.iter().map(|v| v[0]).rev().collect()
    }
}