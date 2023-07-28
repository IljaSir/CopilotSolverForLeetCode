impl Solution {
    pub fn filter_restaurants(restaurants: Vec<Vec<i32>>, vegan_friendly: i32, max_price: i32, max_distance: i32) -> Vec<i32> {
        
        let mut restaurants = restaurants.clone();
        if vegan_friendly == 1 {
            restaurants.retain(|r| r[2] == 1);
        }
        restaurants.retain(|r| r[3] <= max_price && r[4] <= max_distance);
        restaurants.sort_unstable_by(|a, b| b[1].cmp(&a[1]).then(b[0].cmp(&a[0])));
        restaurants.iter().map(|r| r[0]).collect()
    }
}