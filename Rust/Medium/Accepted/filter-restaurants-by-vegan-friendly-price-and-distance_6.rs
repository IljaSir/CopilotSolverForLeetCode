impl Solution {
    pub fn filter_restaurants(restaurants: Vec<Vec<i32>>, vegan_friendly: i32, max_price: i32, max_distance: i32) -> Vec<i32> {
        
        let mut res = restaurants.into_iter().filter(|r| {
            (r[2] == vegan_friendly || vegan_friendly == 0) && r[3] <= max_price && r[4] <= max_distance
        }).collect::<Vec<_>>();
        res.sort_by(|a, b| {
            if a[1] == b[1] {
                b[0].cmp(&a[0])
            } else {
                b[1].cmp(&a[1])
            }
        });
        res.into_iter().map(|r| r[0]).collect()
    }
}